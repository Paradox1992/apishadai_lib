package com.shapi.Models.Utils;

import java.io.Serializable;

public class FilterModel implements Serializable {

    private static final long serialVersionUID = -2895802361944362531L;

    private final FilterItem[] filterItem;
    private String name;

    public FilterModel(FilterItem... filterItem) {
        this.filterItem = filterItem;
    }

    public FilterModel(String name, FilterItem... filterItem) {
        this.filterItem = filterItem;
        this.name = name;
    }

    public FilterItem[] getFilterItem() {
        return this.filterItem;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
