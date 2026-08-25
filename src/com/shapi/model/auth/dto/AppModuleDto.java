package com.shapi.model.auth.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public final record AppModuleDto(@JsonProperty("codigo")
        String codigo) {

    public String getCodigo() {
        return codigo;
    }

}
