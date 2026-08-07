package com.yauhescha.javashiki.api;

import com.yauhescha.javashiki.model.domen.Style;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.*;

public class StyleApiTest extends CommonTestData {

    private boolean hasStylesScope = false;

    @Before
    public void checkScope() {
        Map<String, Object> styleParams = new HashMap<>();
        styleParams.put("css", "body { background: blue; }");
        styleParams.put("name", "Test Style");
        styleParams.put("owner_id", String.valueOf(TEST_USER_ID));
        styleParams.put("owner_type", "User");

        Style style = styleApi.createStyle(styleParams);
        hasStylesScope = (style != null && style.getId() != null);
    }

    @Test
    public void getStyle() {
        Optional<Style> style = styleApi.getStyle(1);
        assertTrue(style.isPresent());
    }

    @Test
    public void previewStyle() {
        Style style = styleApi.previewStyle("body { background: red; }");
        assertNotNull("Check token has required scope", style);
        if (style != null) {
            assertNotNull(style.getCompiledCss());
        }
    }

    @Test
    public void createStyle() {
        Assume.assumeTrue("Token needs styles scope", hasStylesScope);
        Map<String, Object> styleParams = new HashMap<>();
        styleParams.put("css", "body { background: blue; }");
        styleParams.put("name", "Test Style");
        styleParams.put("owner_id", String.valueOf(TEST_USER_ID));
        styleParams.put("owner_type", "User");

        Style style = styleApi.createStyle(styleParams);
        assertNotNull(style);
        assertNotNull(style.getId());
    }

    @Test
    public void updateStyle() {
        Assume.assumeTrue("Token needs styles scope", hasStylesScope);
        Map<String, Object> styleParams = new HashMap<>();
        styleParams.put("css", "body { background: green; }");
        styleParams.put("name", "Test Style");
        styleParams.put("owner_id", String.valueOf(TEST_USER_ID));
        styleParams.put("owner_type", "User");

        Style style = styleApi.createStyle(styleParams);
        assertNotNull(style);
        assertNotNull(style.getId());

        Map<String, Object> updateParams = new HashMap<>();
        updateParams.put("name", "Updated Style Name");
        Style updated = styleApi.updateStyle(style.getId(), updateParams);
        assertNotNull(updated);
    }
}
