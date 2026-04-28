package com.shapi.Models.auth.aux1;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;

public final record VistaDTO(
        @JsonProperty("vistai") VistaInternaDTO vistai,
        @JsonProperty("accionesi") List<AccionDTO> accionesi) {

    @JsonCreator
    public VistaDTO(
            @JsonProperty("vistai") VistaInternaDTO vistai,
            @JsonProperty("accionesi") List<AccionDTO> accionesi) {
        this.vistai = vistai;
        this.accionesi = accionesi;
    }

    public List<AccionDTO> getAccionesi() {
        return Collections.unmodifiableList(accionesi);
    }
    public VistaInternaDTO getVistai() {
        return vistai;
    }
}