package com.yauhescha.javashiki.request;

import com.github.kevinsawicki.http.HttpRequest;
import com.yauhescha.javashiki.util.Utils;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.val;

import javax.validation.constraints.NotNull;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Map;

import static com.yauhescha.javashiki.constant.ShikiInfo.URL_API_V1;

@RequiredArgsConstructor
public class ApiRequest<T> {
    private final AuthShikimori authShikimori;
    protected final Class<T> responseType;

    public T execute(@NonNull RequestType requestType, @NonNull String url) {
        return execute(requestType, url, null);
    }

    public T execute(@NonNull RequestType requestType, @NonNull String url, Map<String, Object> params) {
        String fullUrl = URL_API_V1 + url;
        logRequest(requestType.name(), fullUrl, params);

        String json;
        if (RequestType.PATCH.equals(requestType) || RequestType.PUT.equals(requestType) || RequestType.POST.equals(requestType)) {
            json = executeNonGetDelete(requestType.name(), fullUrl, params);
        } else {
            HttpRequest httpRequest = buildHttpRequest(requestType, fullUrl, params);
            json = executeJSON(httpRequest);
        }
        return Utils.fromJson(json, responseType);
    }

    public T executePostImage(@NonNull String url, @NotNull File file, String linkedType) {
        HttpRequest httpRequest = buildHttpRequest(RequestType.POST, URL_API_V1 + url, null);
        httpRequest.part("image", file.getName(), new File(file.getAbsolutePath()));
        if (linkedType != null) {
            httpRequest.part("linked_type", linkedType);
        }
        return Utils.fromJson(executeJSON(httpRequest), responseType);
    }

    private HttpRequest buildHttpRequest(RequestType requestType, String url, Map<String, Object> params) {
        HttpRequest request;
        if (RequestType.POST.equals(requestType)) {
            request = buildPostRequest(url, params);
        } else if (RequestType.DELETE.equals(requestType)) {
            request = buildDeleteRequest(url, params);
        } else {
            request = buildGetRequest(url, params);
        }
        return addAuthorizationHeaders(request);
    }

    private HttpRequest buildGetRequest(String url, Map<String, Object> params) {
        HttpRequest request;
        if (params == null) {
            request = HttpRequest.get(url);
        } else {
            request = HttpRequest.get(url, true, getParams(params));
        }
        return request;
    }

    private HttpRequest buildPostRequest(String url, Map<String, Object> params) {
        HttpRequest request;
        if (params == null) {
            request = HttpRequest.post(url);
        } else {
            request = HttpRequest.post(url, true, getParams(params));
        }
        return request;
    }

    private HttpRequest buildDeleteRequest(String url, Map<String, Object> params) {
        HttpRequest request;
        if (params == null) {
            request = HttpRequest.delete(url);
        } else {
            request = HttpRequest.delete(url, true, getParams(params));
        }
        return request;
    }

    private HttpRequest addAuthorizationHeaders(HttpRequest request) {
        return request
            .userAgent(getUserAgentForHeader())
            .authorization(getAuthorizationForHeader());
    }

    protected String executeJSON(HttpRequest request) {
        val code = request.code();
        val json = request.body();
        logResponse(request.url().toString(), code, json);

        if (checkCode429(code)) {
            return executeJSON(copyRequest(request));
        }

        if (checkCode401(code)) {
            authShikimori.refreshToken();
            return executeJSON(request);
        }

        if (code == 404) {
            return null;
        }

        return json;
    }

    private String executeNonGetDelete(String method, String urlStr, Map<String, Object> params) {
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            String actualMethod = method;
            if ("PATCH".equals(method) || "DELETE".equals(method)) {
                conn.setRequestMethod("POST");
                conn.setRequestProperty("X-HTTP-Method-Override", method);
                actualMethod = "POST (X-HTTP-Method-Override: " + method + ")";
            } else {
                conn.setRequestMethod(method);
            }

            conn.setRequestProperty("User-Agent", getUserAgentForHeader());
            conn.setRequestProperty("Authorization", getAuthorizationForHeader());
            conn.setRequestProperty("Content-Type", "application/json");

            logRequest(actualMethod, urlStr, params);

            if (params != null && !params.isEmpty()) {
                conn.setDoOutput(true);
                String jsonBody = Utils.toJson(params);
                logRequestBody(jsonBody);
                try (OutputStream os = conn.getOutputStream()) {
                    os.write(jsonBody.getBytes(StandardCharsets.UTF_8));
                }
            }

            int code = conn.getResponseCode();

            if (checkCode429(code)) {
                Thread.sleep(1000);
                return executeNonGetDelete(method, urlStr, params);
            }

            if (checkCode401(code)) {
                authShikimori.refreshToken();
                return executeNonGetDelete(method, urlStr, params);
            }

            if (code == 404) {
                logResponse(urlStr, code, "null (404 Not Found)");
                return null;
            }

            BufferedReader reader;
            if (code >= 200 && code < 300) {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            }

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
            conn.disconnect();

            String responseBody = response.toString().trim();
            logResponse(urlStr, code, responseBody);

            if (responseBody.startsWith("<!DOCTYPE") || responseBody.startsWith("<html")) {
                System.out.println("  [WARN] Response is HTML page, not JSON");
                return null;
            }
            if (responseBody.isEmpty() || responseBody.equals("{}") || responseBody.equals("null")) {
                System.out.println("  [INFO] Empty response body");
                return null;
            }
            return responseBody;
        } catch (Exception e) {
            System.err.println("  [ERROR] " + e.getMessage());
            throw new RuntimeException("Error executing " + method + " request to " + urlStr, e);
        }
    }

    private void logRequest(String method, String url, Map<String, Object> params) {
        System.out.println("\n=== REQUEST ===");
        System.out.println("  Method: " + method);
        System.out.println("  URL: " + url);
        if (params != null && !params.isEmpty()) {
            System.out.println("  Params: " + params);
        }
    }

    private void logRequestBody(String body) {
        System.out.println("  Body: " + body);
    }

    private void logResponse(String url, int code, String body) {
        System.out.println("=== RESPONSE ===");
        System.out.println("  URL: " + url);
        System.out.println("  Status: " + code);
        if (body != null) {
            String truncated = body.length() > 500 ? body.substring(0, 500) + "... (truncated, " + body.length() + " chars total)" : body;
            System.out.println("  Body: " + truncated);
        } else {
            System.out.println("  Body: null");
        }
        System.out.println("================\n");
    }

    private HttpRequest copyRequest(HttpRequest request) {
        return addAuthorizationHeaders(HttpRequest
            .get(request.url()));
    }

    private boolean checkCode401(int code) {
        if (code == 401) {
            if (!authShikimori.getAccessToken().isLoaded() || authShikimori.getAccessToken().isRefreshRequired()) {
                System.out.println("  [WARN] Token expired, trying refresh token...");
                authShikimori.refreshToken();
                return true;
            }
        }
        return false;
    }

    private boolean checkCode429(int code) {
        if (code == 429) {
            System.out.println("  [WARN] Too many requests (429). Calming down 1s...");
            try {
                Thread.sleep(1000);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    private String getAuthorizationForHeader() {
        return "Bearer " + authShikimori.getAccessToken().getAccessToken();
    }

    private String getUserAgentForHeader() {
        return authShikimori.getApplicationName();
    }

    private Object[] getParams(Map<String, Object> params) {
        ArrayList<Object> result = new ArrayList<>();
        params.forEach((k, v) -> {
            result.add(k);
            result.add(v);
        });
        return result.toArray(new Object[0]);
    }
}
