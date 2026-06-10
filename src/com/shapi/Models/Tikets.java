package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class Tikets {

    private Integer id;
    private Promociones promocion;
    private Clientes cliente;
    private int ntiket;
    private User usuario;
    private Stock stock;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public Tikets() {
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Tikets(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public Tikets(
            @JsonProperty("id") Integer id,
            @JsonProperty("promocion") Promociones promocion,
            @JsonProperty("cliente") Clientes cliente,
            @JsonProperty("ntiket") int ntiket,
            @JsonProperty("usuario") User usuario,
            @JsonProperty("stock") Stock stock,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated_at") OffsetDateTime updated_at) {
        this.id = id;
        this.promocion = promocion;
        this.cliente = cliente;
        this.ntiket = ntiket;
        this.usuario = usuario;
        this.stock = stock;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

}
