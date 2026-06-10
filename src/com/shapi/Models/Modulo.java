package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;


@Data
public class Modulo {

    private Integer id;
    private String nombre;
    private String codigo;
    private ModuloEstados estado;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public Modulo() {
    }
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Modulo(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    
    public Modulo(
            @JsonProperty("id") Integer id,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("codigo") String codigo,
            @JsonProperty("estado") ModuloEstados estado,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated_at") OffsetDateTime updated_at) {
        this.id = id;
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
