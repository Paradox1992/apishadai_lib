package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class Departamentos {

    private Integer id;
    private String nombre;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public Departamentos() {
    }
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Departamentos(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    
    public Departamentos(
            @JsonProperty("id") Integer id,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated_at") OffsetDateTime updated_at) {
        this.id = id;
        this.nombre = nombre;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
