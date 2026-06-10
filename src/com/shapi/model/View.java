package com.shapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class View {

    private Integer id;
    private AppModule modulo;
    private String nombre;
    private String codigo;
    private ViewStatus estado;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public View() {
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public View(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public View(
            @JsonProperty("id") Integer id,
            @JsonProperty("modulo") AppModule modulo,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("codigo") String codigo,
            @JsonProperty("estado") ViewStatus estado,
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
