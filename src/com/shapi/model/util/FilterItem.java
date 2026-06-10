package com.shapi.model.util;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilterItem {

    @JsonProperty("key")
    private final String key;

    @JsonProperty("value")
    private final Object value;

    @JsonProperty("operator")
    private final String operator;

    @JsonProperty("logicalOperator")
    private final String logicalOperator;

    public FilterItem(String key, Object value, String operator, String logicalOperator) {
        this.key = key;
        this.value = value;
        this.operator = operator;
        this.logicalOperator = logicalOperator;
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

    /**
     * @return the operator
     */
    public String getOperator() {
        return this.operator;
    }

    /**
     * @return the logicalOperator
     */
    public String getLogicalOperator() {
        return this.logicalOperator;
    }

}
