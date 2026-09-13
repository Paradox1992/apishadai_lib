package rsc.factory;

import com.shapi.model.auth.Session;
import rsc.repository.farma.LaboratoriosRepository;
import rsc.repository.farma.ProductoRepository;
import rsc.repository.farma.ProveedoresRepository;
import rsc.service.farma.LaboratoriosService;
import rsc.service.farma.ProductoService;
import rsc.service.farma.ProveedoresService;

public final class FarmaFactory {

    public static final ProveedoresService PROVEEDORES_SERVICE(Session session) {
        return (ProveedoresService) new ProveedoresRepository().setSession(session);
    }

    public static final LaboratoriosService LABORATORIOS_SERVICE(Session session) {
        return (LaboratoriosService) new LaboratoriosRepository().setSession(session);
    }

    public static final ProductoService PRODUCTO_SERVICE() {
        return new ProductoRepository();
    }
}
