package com.shapi.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shapi.model.util.FilterItem;
import com.shapi.model.util.FilterModel;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class FilterModelSerializationTest {

    private final ObjectMapper mapper = new ObjectMapper();

    @Test
    public void serializesOnlyPublicFilterFields() throws Exception {
        FilterModel filter = new FilterModel(
                "tickets",
                new FilterItem("promocion", 12)
        );

        JsonNode json = mapper.readTree(mapper.writeValueAsString(filter));
        JsonNode item = json.get("filterItems").get(0);

        assertEquals("promocion", item.get("key").asText());
        assertEquals(12, item.get("value").asInt());
        assertFalse(item.has("logicalOperator"));
        assertFalse(item.has("operator"));
        assertFalse(json.has("filterItem"));
    }

    @Test
    public void legacyConstructorDoesNotSerializeServerSideOperators() throws Exception {
        FilterItem item = new FilterItem("promocion", 12, "LIKE_ALL", "invalid");

        JsonNode json = mapper.readTree(mapper.writeValueAsString(item));

        assertFalse(json.has("logicalOperator"));
        assertFalse(json.has("operator"));
        assertTrue(json.has("key"));
        assertTrue(json.has("value"));
    }

    @Test
    public void serializesWorkLunchReportDateRange() throws Exception {
        FilterModel filter = new FilterModel(
                "worklunch_report",
                new FilterItem("usuario", 7),
                new FilterItem("work_date", List.of("2026-09-01", "2026-09-02"))
        );

        JsonNode json = mapper.readTree(mapper.writeValueAsString(filter));

        assertEquals("worklunch_report", json.get("name").asText());
        assertEquals(7, json.get("filterItems").get(0).get("value").asInt());
        assertEquals(
                "2026-09-01",
                json.get("filterItems").get(1).get("value").get(0).asText()
        );
        assertEquals(
                "2026-09-02",
                json.get("filterItems").get(1).get("value").get(1).asText()
        );
    }

    @Test
    public void sanitizePreservesSafeValuesAndNormalizesUnicode() {
        FilterItem[] originalItems = {
            new FilterItem("nombre", "  Ｍaría José  "),
            null,
            new FilterItem("work_date", List.of("2026-09-01", "2026-09-02"))
        };

        FilterModel sanitized = new FilterModel("tickets", originalItems).sanitize();
        FilterItem[] sanitizedItems = sanitized.filterItems();

        assertEquals(2, sanitizedItems.length);
        assertEquals("María José", sanitizedItems[0].getValue());
        assertEquals(
                List.of("2026-09-01", "2026-09-02"),
                sanitizedItems[1].getValue()
        );
        assertNotSame(originalItems, sanitizedItems);
    }

    @Test
    public void sanitizeRejectsSpecialCharactersAndExecutablePayloads() {
        assertInvalid(new FilterItem("nombre", "<script>alert(1)</script>"));
        assertInvalid(new FilterItem("nombre", "'; DROP TABLE users; --"));
        assertInvalid(new FilterItem("nombre", "powershell -enc ZQB2AGkAbAA="));
        assertInvalid(new FilterItem("nombre", "../server/config"));
        assertInvalid(new FilterItem("nombre", "javascript:alert"));
    }

    @Test
    public void sanitizeRejectsHiddenUnicodeAndUnsafeKeys() {
        assertInvalid(new FilterItem("nombre", "admin\u202Etxt"));
        assertInvalid(new FilterItem("nombre", "zero\u200Bwidth"));
        assertInvalid(new FilterItem("user.name", "safe"));
    }

    @Test
    public void sanitizeValidatesNestedValues() {
        assertInvalid(new FilterItem(
                "work_date",
                List.of("2026-09-01", "SELECT password FROM users")
        ));
    }

    @Test
    public void sanitizedFilterDoesNotExposeItsInternalArray() {
        FilterModel sanitized = new FilterModel(
                "tickets",
                new FilterItem("nombre", "María")
        ).sanitize();

        FilterItem[] exposed = sanitized.filterItems();
        exposed[0] = new FilterItem("nombre", "<script>");

        assertEquals("María", sanitized.filterItems()[0].getValue());
    }

    private static void assertInvalid(FilterItem item) {
        try {
            new FilterModel("tickets", item).sanitize();
            fail("Expected sanitize() to reject an unsafe filter item");
        } catch (IllegalArgumentException expected) {
            // Expected: unsafe data must never be sent to the API.
        }
    }
}
