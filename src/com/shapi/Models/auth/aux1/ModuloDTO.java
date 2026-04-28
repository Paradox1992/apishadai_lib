package com.shapi.Models.auth.aux1;

import com.fasterxml.jackson.annotation.JsonProperty;

public final record ModuloDTO(@JsonProperty("codigo")
        String codigo) {

    public String getCodigo() {
        return codigo;
    }

}
