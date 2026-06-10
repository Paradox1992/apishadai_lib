package com.shapi.model.auth.dto;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collections;
import java.util.List;

public final record ViewDto(
        @JsonProperty("vistai") InternalViewDto vistai,
        @JsonProperty("accionesi") List<ActionDto> accionesi) {

    @JsonCreator
    public ViewDto(
            @JsonProperty("vistai") InternalViewDto vistai,
            @JsonProperty("accionesi") List<ActionDto> accionesi) {
        this.vistai = vistai;
        this.accionesi = accionesi;
    }

    public List<ActionDto> getAccionesi() {
        return Collections.unmodifiableList(accionesi);
    }
    public InternalViewDto getInternalView() {
        return vistai;
    }
}