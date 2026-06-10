package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class Actionsvistas {

    private Integer id;
    private Vista vista;
    private String codigo;
    private String nombre;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public Actionsvistas() {
    }
    
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Actionsvistas(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    
    public Actionsvistas(
            @JsonProperty("id") Integer id,
            @JsonProperty("vista") Vista vista,
            @JsonProperty("codigo") String codigo,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated_at") OffsetDateTime updated_at) {
        this.id = id;
        this.vista = vista;
        this.codigo = codigo;
        this.nombre = nombre;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return null;
    }

}
