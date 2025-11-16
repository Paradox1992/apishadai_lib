package com.shapi.Models.auth;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shapi.Models.Utils.ActionButton;
import java.util.Collections;
import java.util.List;
import javax.accessibility.AccessibleContext;

@JsonIgnoreProperties(ignoreUnknown = true)
public final class Session extends ActionButton {

    private final String token;
    private final String uname;
    private final String urol;
    private final String stockname;
    private final int stockid;
    private final int deviceid;
    private final List<Spermiso> spermisos;

    /**
     *
     * @param token
     * @param uname
     * @param urol
     * @param stockname
     * @param stockid
     * @param deviceid
     * @param spermisos
     */
    @JsonCreator
    public Session(
            @JsonProperty("token") String token,
            @JsonProperty("uname") String uname,
            @JsonProperty("urol") String urol,
            @JsonProperty("stockname") String stockname,
            @JsonProperty("stockid") int stockid,
            @JsonProperty("deviceid") int deviceid,
            @JsonProperty("spermisos") List<Spermiso> spermisos
    ) {
        this.token = token;
        this.uname = uname;
        this.urol = urol;
        this.stockname = stockname;
        this.stockid = stockid;
        this.deviceid = deviceid;
        this.spermisos = spermisos != null ? Collections.unmodifiableList(spermisos) : Collections.emptyList();
    }

    public Session() {
        this.token = null;
        this.uname = null;
        this.urol = null;
        this.stockname = null;
        this.stockid = 0;
        this.deviceid = 0;
        this.spermisos = null;
    }

    public String getToken() {
        return token;
    }

    public String getUname() {
        return uname;
    }

    public String getUrol() {
        return urol;
    }

    public String getStockname() {
        return stockname;
    }

    public int getStockid() {
        return stockid;
    }

    public int getDeviceid() {
        return deviceid;
    }

    public List<Spermiso> getPermisos() {
        return Collections.unmodifiableList(spermisos);
    }

    public Session setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
        return this;
    }

    public AccessibleContext getAccessibleContext() {
        return this.accessibleContext;
    }

}
