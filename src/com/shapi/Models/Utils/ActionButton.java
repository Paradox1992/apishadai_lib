package com.shapi.Models.Utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.accessibility.AccessibleContext;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ActionButton {

    @JsonIgnore
    protected AccessibleContext accessibleContext;

}
