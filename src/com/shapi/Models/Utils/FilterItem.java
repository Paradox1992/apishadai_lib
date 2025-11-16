package com.shapi.Models.Utils;

import java.io.Serializable;

public class FilterItem implements Serializable {

    private static final long serialVersionUID = 8023989230698383426L;

    private final String key;
    private final Object value;

    public FilterItem() {
        this.key = null;
        this.value = null;
    }

    public FilterItem(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }
    
}
