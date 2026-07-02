package rsc.factory;

import com.shapi.model.auth.Session;
import rsc.repository.farma.ProveedoresRepository;
import rsc.service.farma.ProveedoresService;

public final class FarmaFactory {

    public static final ProveedoresService PROVEEDORES_SERVICE(Session session) {
        return (ProveedoresService) new ProveedoresRepository().setSession(session);
    }
}
