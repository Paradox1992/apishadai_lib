package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class Vista {

    private Integer id;
    private Modulo modulo;
    private String nombre;
    private String codigo;
    private VistaEstado estado;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public Vista() {
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Vista(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public Vista(
            @JsonProperty("id") Integer id,
            @JsonProperty("modulo") Modulo modulo,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("codigo") String codigo,
            @JsonProperty("estado") VistaEstado estado,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated_at") OffsetDateTime updated_at) {
        this.id = id;
        this.modulo = modulo;
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
