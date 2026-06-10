package com.shapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class ViewAction {

    private Integer id;
    private View vista;
    private String codigo;
    private String nombre;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public ViewAction() {
    }
    
    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ViewAction(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    
    public ViewAction(
            @JsonProperty("id") Integer id,
            @JsonProperty("vista") View vista,
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
        return nombre != null ? nombre : "";
    }

}
