package com.shapi.model.auth.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final record InternalViewDto(
        @JsonProperty("codigo")
        String codigo) {

    @JsonCreator
    public InternalViewDto(@JsonProperty("codigo") String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }
}
