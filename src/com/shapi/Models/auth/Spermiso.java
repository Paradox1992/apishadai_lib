package com.shapi.Models.auth;

import com.shapi.Models.auth.aux1.ModuloDTO;
import com.shapi.Models.auth.aux1.VistaDTO;
import java.util.Collections;
import java.util.List;

public final record Spermiso(ModuloDTO modulo_l, List<VistaDTO> vistas_l) {

    public List<VistaDTO> getVistas_l() {
        return Collections.unmodifiableList(vistas_l);
    }

    public ModuloDTO getModulo_l() {
        return modulo_l;
    }

}
