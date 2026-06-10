package com.shapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class Municipality {

    private Integer id;
    private String nombre;
    private Department departamento;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public Municipality() {
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Municipality(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public Municipality(
            @JsonProperty("id") Integer id,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("departamento") Department departamento,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated_at") OffsetDateTime updated_at) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
