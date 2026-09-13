package rsc.repository.farma;

import com.shapi.model.auth.Session;
import rsc.factory.ProductoFactory;
import rsc.service.farma.ProductoService;
import rsc.service.farma.ProdUnidadService;
import rsc.service.farma.ProdEstadoService;
import rsc.service.farma.ProdCategoriaService;
import rsc.service.farma.FamPresentacionService;
import rsc.service.farma.FamAdministracionService;
import rsc.service.farma.FamiliaService;
import rsc.service.farma.ConcentracionService;
import rsc.service.farma.PrincipalActivoService;

public final class ProductoRepository implements ProductoService {

    @Override
    public ProdUnidadService prodUnidadService(Session session) {
        return ProductoFactory.PROD_UNIDAD_SERVICE(session);
    }

    @Override
    public ProdEstadoService prodEstadoService(Session session) {
        return ProductoFactory.PROD_ESTADO_SERVICE(session);
    }

    @Override
    public ProdCategoriaService prodCategoriaService(Session session) {
        return ProductoFactory.PROD_CATEGORIA_SERVICE(session);
    }

    @Override
    public FamPresentacionService famPresentacionService(Session session) {
        return ProductoFactory.FAM_PRESENTACION_SERVICE(session);
    }

    @Override
    public FamAdministracionService famAdministracionService(Session session) {
        return ProductoFactory.FAM_ADMINISTRACION_SERVICE(session);
    }

    @Override
    public FamiliaService familiaService(Session session) {
        return ProductoFactory.FAMILIA_SERVICE(session);
    }

    @Override
    public ConcentracionService concentracionService(Session session) {
        return ProductoFactory.CONCENTRACION_SERVICE(session);
    }

    @Override
    public PrincipalActivoService principalActivoService(Session session) {
        return ProductoFactory.PRINCIPAL_ACTIVO_SERVICE(session);
    }

}
