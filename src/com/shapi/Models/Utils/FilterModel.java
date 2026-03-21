package com.shapi.Models.Utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Objects;

public final class FilterModel {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("filterItem")
    private final FilterItem[] filterItem;

    public FilterModel(String name, FilterItem... filterItem) {
        this.name = name;
        this.filterItem = filterItem;
    }

    public String name() {
        return name;
    }

    public FilterItem[] filterItem() {
        return filterItem;
    }

    public FilterModel sanitize() {
        FilterItem[] sanitizedItems = Arrays.stream(filterItem)
                .filter(Objects::nonNull)
                .toArray(FilterItem[]::new);
        return new FilterModel(name, sanitizedItems);
    }
}
