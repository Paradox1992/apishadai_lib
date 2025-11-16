package com.shapi.Models.auth.aux1;

import java.util.Collections;
import java.util.List;

public final record VistaDTO(VistaInternaDTO vistai, List<AccionDTO> accionesi) {

    public List<AccionDTO> getAccionesi() {
        return Collections.unmodifiableList(accionesi);
    }

    public VistaInternaDTO getVistai() {
        return vistai;
    }

}
