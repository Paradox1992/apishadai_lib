package rsc.Factories;

import com.shapi.Models.auth.Session;
import rsc.Repositores.UbicacionRepositories.DepartamentosRepository;
import rsc.Repositores.UbicacionRepositories.MunicipiosRepository;
import rsc.Services.UbicacionServices.DepartamentosService;
import rsc.Services.UbicacionServices.MunicipiosService;

public final class UbicacionFactory {

    public static final DepartamentosService DEPTO_SERVICE(Session session) {
        return (DepartamentosService) new DepartamentosRepository().setSession(session);
    }

    public static final MunicipiosService MNC_SERVICE(Session session) {
        return (MunicipiosService) new MunicipiosRepository().setSession(session);
    }
}
