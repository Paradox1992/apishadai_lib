package rsc.service;

import com.shapi.model.auth.Session;
import rsc.service.farma.LaboratoriosService;
import rsc.service.farma.ProductoService;
import rsc.service.farma.ProveedoresService;

public interface FarmaService {

    ProveedoresService proveedoresService(Session session);

    LaboratoriosService laboratoriosService(Session session);

    ProductoService productoService();

}
