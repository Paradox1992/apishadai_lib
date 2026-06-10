package com.shapi.model.auth;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shapi.model.auth.dto.AppModuleDto;
import com.shapi.model.auth.dto.ViewDto;
import java.util.Collections;
import java.util.List;

public final record SessionPermission(
        @JsonProperty("modulo_l") AppModuleDto modulo_l,
        @JsonProperty("vistas_l") List<ViewDto> vistas_l) {

    @JsonCreator
    public SessionPermission(
            @JsonProperty("modulo_l") AppModuleDto modulo_l,
            @JsonProperty("vistas_l") List<ViewDto> vistas_l) {
        this.modulo_l = modulo_l;
        this.vistas_l = vistas_l;
    }

    public List<ViewDto> getViews() {
        return Collections.unmodifiableList(vistas_l);
    }
    public AppModuleDto getModule() {
        return modulo_l;
    }
}