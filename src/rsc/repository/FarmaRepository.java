package rsc.repository;

import com.shapi.model.auth.Session;
import rsc.factory.FarmaFactory;
import rsc.service.FarmaService;
import rsc.service.farma.LaboratoriosService;
import rsc.service.farma.ProductoService;
import rsc.service.farma.ProveedoresService;

public final class FarmaRepository implements FarmaService {

    @Override
    public ProveedoresService proveedoresService(Session session) {
        return FarmaFactory.PROVEEDORES_SERVICE(session);
    }

    @Override
    public LaboratoriosService laboratoriosService(Session session) {
        return FarmaFactory.LABORATORIOS_SERVICE(session);
    }
    @Override
    public ProductoService productoService() {
        return FarmaFactory.PRODUCTO_SERVICE();
    }

}
