package com.shapi.Models.auth;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shapi.Models.auth.aux1.ModuloDTO;
import com.shapi.Models.auth.aux1.VistaDTO;
import java.util.Collections;
import java.util.List;

public final record Spermiso(
        @JsonProperty("modulo_l") ModuloDTO modulo_l,
        @JsonProperty("vistas_l") List<VistaDTO> vistas_l) {

    @JsonCreator
    public Spermiso(
            @JsonProperty("modulo_l") ModuloDTO modulo_l,
            @JsonProperty("vistas_l") List<VistaDTO> vistas_l) {
        this.modulo_l = modulo_l;
        this.vistas_l = vistas_l;
    }

    public List<VistaDTO> getVistas_l() {
        return Collections.unmodifiableList(vistas_l);
    }
    public ModuloDTO getModulo_l() {
        return modulo_l;
    }
}