package rsc.service;

import com.shapi.model.auth.Session;
import rsc.service.location.*;

public interface LocationService {

    DepartmentService departamentosService(Session session);

    MunicipalityService municipalitiesService(Session session);
}
