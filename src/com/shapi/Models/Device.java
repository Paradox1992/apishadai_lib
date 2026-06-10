package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;


@Data
public class Device {

    private Integer id;
    private String ip;
    private String ip2;
    private String name;
    private String displayname;
    private Stock stock;
    private DeviceEstado estado;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public Device() {
    }
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Device(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    
    public Device(
            @JsonProperty("id") Integer id,
            @JsonProperty("ip") String ip,
            @JsonProperty("ip2") String ip2,
            @JsonProperty("name") String name,
            @JsonProperty("displayname") String displayname,
            @JsonProperty("stock") Stock stock,
            @JsonProperty("estado") DeviceEstado estado,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated_at") OffsetDateTime updated_at) {
        this.id = id;
        this.ip = ip;
        this.ip2 = ip2;
        this.name = name;
        this.displayname = displayname;
        this.stock = stock;
        this.estado = estado;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return null;
    }

}
