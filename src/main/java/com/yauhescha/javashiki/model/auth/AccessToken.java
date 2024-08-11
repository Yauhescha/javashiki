package com.yauhescha.javashiki.model.auth;

import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@ToString(callSuper = true)
@Data
public class AccessToken implements Serializable {
    @SerializedName("access_token")
    private String accessToken;

    @SerializedName("token_type")
    private String tokenType;

    @SerializedName("refresh_token")
    private String refreshToken;

    @SerializedName("expires_in")
    private long expiresIn;

    @SerializedName("created_at")
    private long createdAt;

    public boolean isRefreshRequired() {
        return (createdAt + expiresIn) * 1000 < System.currentTimeMillis();
    }

    public boolean isLoaded() {
        return accessToken != null || !isRefreshRequired();
    }
}
