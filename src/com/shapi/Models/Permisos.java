package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class Permisos {

    private Integer id;
    private User usuario;
    private Modulo modulo;
    private Vista vista;
    private Actionsvistas actionvista;
    private TiposTiempo tipo_tiempo;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public Permisos() {
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Permisos(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public Permisos(
            @JsonProperty("id") Integer id,
            @JsonProperty("usuario") User usuario,
            @JsonProperty("modulo") Modulo modulo,
            @JsonProperty("vista") Vista vista,
            @JsonProperty("actionvista") Actionsvistas actionvista,
            @JsonProperty("tipo_tiempo") TiposTiempo tipo_tiempo,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated_at") OffsetDateTime updated_at) {
        this.id = id;
        this.usuario = usuario;
        this.modulo = modulo;
        this.vista = vista;
        this.actionvista = actionvista;
        this.tipo_tiempo = tipo_tiempo;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return null;
    }

}
