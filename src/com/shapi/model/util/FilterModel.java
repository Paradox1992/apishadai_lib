package com.shapi.model.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.Normalizer;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.regex.Pattern;

public final class FilterModel {

    private static final int MAX_FILTER_ITEMS = 100;
    private static final int MAX_COLLECTION_ITEMS = 100;
    private static final int MAX_NESTING_DEPTH = 4;
    private static final int MAX_STRING_LENGTH = 512;

    private static final Pattern SAFE_IDENTIFIER = Pattern.compile("[A-Za-z][A-Za-z0-9_]{0,63}");
    private static final Pattern SAFE_TEXT = Pattern.compile("[\\p{L}\\p{M}\\p{N} .,@_+:/-]*");
    private static final Pattern DANGEROUS_COMMAND = Pattern.compile(
            "(?:(?:^|/)\\.\\.(?:/|$)"
            + "|\\bselect\\b.{0,80}\\bfrom\\b"
            + "|\\bunion\\s+select\\b"
            + "|\\binsert\\s+into\\b"
            + "|\\bupdate\\b.{0,80}\\bset\\b"
            + "|\\bdelete\\s+from\\b"
            + "|\\b(?:drop|alter|truncate|create)\\s+(?:table|database|schema)\\b"
            + "|\\b(?:exec(?:ute)?|xp_cmdshell)\\b"
            + "|\\bcmd(?:\\.exe)?\\s+/[ck]\\b"
            + "|\\b(?:powershell(?:\\.exe)?|pwsh)\\b"
            + "|\\b(?:bash|zsh|ksh|sh)\\s+-c\\b"
            + "|\\brm\\s+-[a-z]*r[a-z]*f\\b"
            + "|\\b(?:curl|wget)\\s+https?://"
            + "|\\b(?:javascript|data|file):"
            + "|\\binvoke-expression\\b)",
            Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE
    );

    @JsonProperty("name")
    private final String name;

    @JsonProperty("filterItems")
    private final FilterItem[] filterItems;

    public FilterModel(String name, FilterItem... filterItems) {
        this.name = name;
        this.filterItems = filterItems == null ? null : filterItems.clone();
    }

    public String name() {
        return name;
    }

    public FilterItem[] filterItems() {
        return filterItems == null ? null : filterItems.clone();
    }

    /**
     * @return the filter items
     * @deprecated Use {@link #filterItems()}.
     */
    @Deprecated
    public FilterItem[] filterItem() {
        return filterItems();
    }

    /**
     * Builds a validated, defensive copy suitable for transport to the API.
     * This is a client-side defense in depth; the server must still whitelist
     * fields and use parameterized queries.
     *
     * @return a new model containing only normalized and validated values
     * @throws IllegalArgumentException when any filter contains unsafe data
     */
    public FilterModel sanitize() {
        String sanitizedName = sanitizeIdentifier(name, "filter name");

        if (filterItems == null || filterItems.length == 0) {
            return new FilterModel(sanitizedName);
        }
        if (filterItems.length > MAX_FILTER_ITEMS) {
            throw new IllegalArgumentException("Too many filter items");
        }

        FilterItem[] sanitizedItems = Arrays.stream(filterItems)
                .filter(Objects::nonNull)
                .map(FilterModel::sanitizeItem)
                .toArray(FilterItem[]::new);

        return new FilterModel(sanitizedName, sanitizedItems);
    }

    private static FilterItem sanitizeItem(FilterItem item) {
        String key = sanitizeIdentifier(item.getKey(), "filter key");
        Object value = sanitizeValue(item.getValue(), 0);
        return new FilterItem(key, value);
    }

    private static String sanitizeIdentifier(String value, String field) {
        String normalized = normalizeText(value, field, 64);
        if (!SAFE_IDENTIFIER.matcher(normalized).matches()) {
            throw new IllegalArgumentException(field + " contains invalid characters");
        }
        return normalized;
    }

    private static Object sanitizeValue(Object value, int depth) {
        if (value == null) {
            return null;
        }
        if (depth > MAX_NESTING_DEPTH) {
            throw new IllegalArgumentException("Filter value is nested too deeply");
        }
        if (value instanceof CharSequence || value instanceof Character) {
            return sanitizeString(value.toString());
        }
        if (value instanceof Boolean
                || value instanceof Byte
                || value instanceof Short
                || value instanceof Integer
                || value instanceof Long
                || value instanceof BigInteger
                || value instanceof BigDecimal) {
            return value;
        }
        if (value instanceof Float number) {
            if (!Float.isFinite(number)) {
                throw new IllegalArgumentException("Filter value must be a finite number");
            }
            return number;
        }
        if (value instanceof Double number) {
            if (!Double.isFinite(number)) {
                throw new IllegalArgumentException("Filter value must be a finite number");
            }
            return number;
        }
        if (value instanceof UUID
                || value instanceof Date
                || value instanceof TemporalAccessor
                || value instanceof TemporalAmount) {
            return value;
        }
        if (value instanceof Enum<?> enumValue) {
            return sanitizeString(enumValue.name());
        }
        if (value instanceof Collection<?> collection) {
            return sanitizeCollection(collection, depth + 1);
        }
        if (value.getClass().isArray()) {
            return sanitizeArray(value, depth + 1);
        }

        throw new IllegalArgumentException(
                "Unsupported filter value type: " + value.getClass().getName()
        );
    }

    private static List<Object> sanitizeCollection(Collection<?> values, int depth) {
        if (values.size() > MAX_COLLECTION_ITEMS) {
            throw new IllegalArgumentException("Too many filter values");
        }

        List<Object> sanitized = new ArrayList<>(values.size());
        for (Object value : values) {
            sanitized.add(sanitizeValue(value, depth));
        }
        return Collections.unmodifiableList(sanitized);
    }

    private static List<Object> sanitizeArray(Object values, int depth) {
        int length = Array.getLength(values);
        if (length > MAX_COLLECTION_ITEMS) {
            throw new IllegalArgumentException("Too many filter values");
        }

        List<Object> sanitized = new ArrayList<>(length);
        for (int index = 0; index < length; index++) {
            sanitized.add(sanitizeValue(Array.get(values, index), depth));
        }
        return Collections.unmodifiableList(sanitized);
    }

    private static String sanitizeString(String value) {
        String normalized = normalizeText(value, "filter value", MAX_STRING_LENGTH);
        if (!SAFE_TEXT.matcher(normalized).matches()) {
            throw new IllegalArgumentException("Filter value contains invalid characters");
        }
        if (DANGEROUS_COMMAND.matcher(normalized).find()) {
            throw new IllegalArgumentException("Filter value contains a forbidden command");
        }
        return normalized;
    }

    private static String normalizeText(String value, String field, int maxLength) {
        if (value == null) {
            throw new IllegalArgumentException(field + " cannot be null");
        }
        if (containsForbiddenUnicode(value)) {
            throw new IllegalArgumentException(field + " contains hidden or control characters");
        }

        String normalized = Normalizer.normalize(value, Normalizer.Form.NFKC).strip();
        if (normalized.length() > maxLength) {
            throw new IllegalArgumentException(field + " is too long");
        }
        if (containsForbiddenUnicode(normalized)) {
            throw new IllegalArgumentException(field + " contains hidden or control characters");
        }
        return normalized;
    }

    private static boolean containsForbiddenUnicode(String value) {
        return value.codePoints().anyMatch(codePoint -> {
            int type = Character.getType(codePoint);
            return Character.isISOControl(codePoint)
                    || type == Character.FORMAT
                    || type == Character.PRIVATE_USE
                    || type == Character.SURROGATE
                    || type == Character.UNASSIGNED
                    || type == Character.LINE_SEPARATOR
                    || type == Character.PARAGRAPH_SEPARATOR;
        });
    }
}
