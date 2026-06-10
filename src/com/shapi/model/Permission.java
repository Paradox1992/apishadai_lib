package com.shapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class Permission {

    private Integer id;
    private User usuario;
    private AppModule modulo;
    private View vista;
    private ViewAction actionvista;
    private TimeType tipo_tiempo;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public Permission() {
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Permission(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public Permission(
            @JsonProperty("id") Integer id,
            @JsonProperty("usuario") User usuario,
            @JsonProperty("modulo") AppModule modulo,
            @JsonProperty("vista") View vista,
            @JsonProperty("actionvista") ViewAction actionvista,
            @JsonProperty("tipo_tiempo") TimeType tipo_tiempo,
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
        if (actionvista != null) {
            return actionvista.toString();
        }
        if (vista != null) {
            return vista.toString();
        }
        return id != null ? String.valueOf(id) : "";
    }

}
