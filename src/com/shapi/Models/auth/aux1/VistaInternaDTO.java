package com.shapi.Models.auth.aux1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public final record VistaInternaDTO(
        @JsonProperty("codigo")
        String codigo) {

    @JsonCreator
    public VistaInternaDTO(@JsonProperty("codigo") String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
