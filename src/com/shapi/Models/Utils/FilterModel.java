package com.shapi.Models.Utils;

import java.util.Arrays;
import java.util.Objects;

public record FilterModel(String name,FilterItem... filterItem) {

    public FilterModel sanitize() {
        FilterItem[] sanitizedItems = Arrays.stream(filterItem)
                .filter(Objects::nonNull)
                .toArray(FilterItem[]::new);

        return new FilterModel(name, sanitizedItems);
    }
}
