package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;


@Data
public class Promociones {

    private Integer id;
    private String nombre;
    private String descripcion;
    private OffsetDateTime fecha_inicio;
    private OffsetDateTime fecha_fin;
    private PromoEstado estado;
    private int impresiones;
    private int valor;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public Promociones() {
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Promociones(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    
    public Promociones(
            @JsonProperty("id") Integer id,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("descripcion") String descripcion,
            @JsonProperty("fecha_inicio") OffsetDateTime fecha_inicio,
            @JsonProperty("fecha_fin") OffsetDateTime fecha_fin,
            @JsonProperty("estado") PromoEstado estado,
            @JsonProperty("impresiones") int impresiones,
            @JsonProperty("valor") int valor,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated_at") OffsetDateTime updated_at) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.estado = estado;
        this.impresiones = impresiones;
        this.valor = valor;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

}
