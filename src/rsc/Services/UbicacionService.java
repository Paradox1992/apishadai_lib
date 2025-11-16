package rsc.Services;

import com.shapi.Models.auth.Session;
import rsc.Services.UbicacionServices.*;

public interface UbicacionService {

    DepartamentosService departamentosService(Session session);

    MunicipiosService municipiosService(Session session);
}
