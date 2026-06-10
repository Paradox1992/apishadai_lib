package com.shapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class Stock {

    private Integer id;
    private String descripcion;
    private String telefono;
    private String ubicacion;
    private StockStatus estado;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public Stock() {
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Stock(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public Stock(
            @JsonProperty("id") Integer id,
            @JsonProperty("descripcion") String descripcion,
            @JsonProperty("telefono") String telefono,
            @JsonProperty("ubicacion") String ubicacion,
            @JsonProperty("estado") StockStatus estado,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated_at") OffsetDateTime updated_at) {
        this.id = id;
        this.descripcion = descripcion;
        this.telefono = telefono;
        this.ubicacion = ubicacion;
        this.estado = estado;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return this.descripcion;
    }

}
