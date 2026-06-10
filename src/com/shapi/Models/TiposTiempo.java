package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class TiposTiempo {

    private Integer id;
    private String nombre;
    private String cantidad;
    private String unidad;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public TiposTiempo() {
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public TiposTiempo(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public TiposTiempo(
            @JsonProperty("id") Integer id,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("cantidad") String cantidad,
            @JsonProperty("unidad") String unidad,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated_at") OffsetDateTime updated_at) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
