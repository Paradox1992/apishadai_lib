package com.shapi.Models.Utils;
import javax.accessibility.AccessibleContext;

//@JsonIgnoreProperties(ignoreUnknown = true)
public abstract  class ActionButton {

    private String version;
    protected AccessibleContext accessibleContext;

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return version;
    }

}
