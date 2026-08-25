package com.shapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Device {

    private Integer id;
    private String ip;
    private String ip2;
    private String name;
    private String displayname;
    private Stock stock;
    private DeviceStatus estado;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Device(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        if (displayname != null && !displayname.isBlank()) {
            return displayname;
        }

        if (name != null && !name.isBlank()) {
            return name;
        }

        return ip != null ? ip : "";
    }
}
