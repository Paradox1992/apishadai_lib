package com.shapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class Department {

    private Integer id;
    private String nombre;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public Department() {
    }
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Department(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    
    public Department(
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
