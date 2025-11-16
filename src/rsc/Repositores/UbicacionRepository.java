package rsc.Repositores;

import com.shapi.Models.auth.Session;
import rsc.Factories.UbicacionFactory;
import rsc.Services.UbicacionService;
import rsc.Services.UbicacionServices.DepartamentosService;
import rsc.Services.UbicacionServices.MunicipiosService;

public final class UbicacionRepository implements UbicacionService {

    @Override
    public DepartamentosService departamentosService(Session session) {
        return UbicacionFactory.DEPTO_SERVICE(session);
    }

    @Override
    public MunicipiosService municipiosService(Session session) {
        return UbicacionFactory.MNC_SERVICE(session);
    }

}
