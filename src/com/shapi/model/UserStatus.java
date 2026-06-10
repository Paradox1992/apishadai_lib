package com.shapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class UserStatus {

    private Integer id;
    private String descripcion;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public UserStatus() {
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public UserStatus(Integer id) {
        this.id = id;
    }

    public UserStatus(
            @JsonProperty("id") Integer id,
            @JsonProperty("descripcion") String descripcion,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated_at") OffsetDateTime updated_at) {
        this.id = id;
        this.descripcion = descripcion;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return this.descripcion;
    }

}
