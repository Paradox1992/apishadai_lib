package rsc.repository;

import com.shapi.model.auth.Session;
import rsc.factory.LocationFactory;
import rsc.service.LocationService;
import rsc.service.location.DepartmentService;
import rsc.service.location.MunicipalityService;

public final class LocationRepository implements LocationService {

    @Override
    public DepartmentService departamentosService(Session session) {
        return LocationFactory.DEPTO_SERVICE(session);
    }

    @Override
    public MunicipalityService municipalitiesService(Session session) {
        return LocationFactory.MNC_SERVICE(session);
    }

}
