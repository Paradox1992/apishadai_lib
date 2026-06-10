package rsc.factory;

import com.shapi.model.auth.Session;
import rsc.repository.location.DepartmentRepository;
import rsc.repository.location.MunicipalityRepository;
import rsc.service.location.DepartmentService;
import rsc.service.location.MunicipalityService;

public final class LocationFactory {

    public static final DepartmentService DEPTO_SERVICE(Session session) {
        return (DepartmentService) new DepartmentRepository().setSession(session);
    }

    public static final MunicipalityService MNC_SERVICE(Session session) {
        return (MunicipalityService) new MunicipalityRepository().setSession(session);
    }
}
