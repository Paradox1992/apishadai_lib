package com.shapi.model.auth.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public final record ActionDto(
        @JsonProperty("codigo")
        String codigo) {

    public String getCodigo() {
        return codigo;
    }

}
