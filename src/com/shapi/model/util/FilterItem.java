package com.shapi.model.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilterItem {

    @JsonProperty("key")
    private final String key;

    @JsonProperty("value")
    private final Object value;

    public FilterItem(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Compatibilidad temporal con clientes compilados contra el contrato
     * anterior. El conector lógico ya no se serializa ni se envía a la API.
     */
    @Deprecated
    public FilterItem(String key, Object value, String ignoredLogicalOperator) {
        this(key, value);
    }

    /**
     * Compatibilidad temporal con clientes compilados contra el contrato
     * anterior. El operador SQL ya no se serializa ni se envía a la API.
     */
    @Deprecated
    public FilterItem(String key, Object value, String ignoredOperator, String ignoredLogicalOperator) {
        this(key, value);
    }

    /**
     * @return the key
     */
    public String getKey() {
        return this.key;
    }

    /**
     * @return the value
     */
    public Object getValue() {
        return this.value;
    }

}
