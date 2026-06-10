package com.shapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class WorkShift {

    private Integer id;
    private User usuario;
    private Device device;
    private OffsetDateTime wkstart_time;
    private OffsetDateTime wkend_time;
    private OffsetDateTime lunch_start_time;
    private OffsetDateTime lunch_end_time;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public WorkShift() {
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public WorkShift(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public WorkShift(
            @JsonProperty("id") Integer id,
            @JsonProperty("usuario") User usuario,
            @JsonProperty("device") Device device,
            @JsonProperty("wkstart_time") OffsetDateTime wkstart_time,
            @JsonProperty("wkend_time") OffsetDateTime wkend_time,
            @JsonProperty("lunch_start_time") OffsetDateTime lunch_start_time,
            @JsonProperty("lunch_end_time") OffsetDateTime lunch_end_time,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated_at") OffsetDateTime updated_at) {
        this.id = id;
        this.usuario = usuario;
        this.device = device;
        this.wkstart_time = wkstart_time;
        this.wkend_time = wkend_time;
        this.lunch_start_time = lunch_start_time;
        this.lunch_end_time = lunch_end_time;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        if (usuario != null) {
            return usuario.toString();
        }
        if (device != null) {
            return device.toString();
        }
        return id != null ? String.valueOf(id) : "";
    }

}
