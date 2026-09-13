package rsc.factory;

import com.shapi.model.auth.Session;
import rsc.repository.farma.ProdUnidadRepository;
import rsc.repository.farma.ProdEstadoRepository;
import rsc.repository.farma.ProdCategoriaRepository;
import rsc.repository.farma.FamPresentacionRepository;
import rsc.repository.farma.FamAdministracionRepository;
import rsc.repository.farma.FamiliaRepository;
import rsc.repository.farma.ConcentracionRepository;
import rsc.repository.farma.PrincipalActivoRepository;
import rsc.service.farma.ProdUnidadService;
import rsc.service.farma.ProdEstadoService;
import rsc.service.farma.ProdCategoriaService;
import rsc.service.farma.FamPresentacionService;
import rsc.service.farma.FamAdministracionService;
import rsc.service.farma.FamiliaService;
import rsc.service.farma.ConcentracionService;
import rsc.service.farma.PrincipalActivoService;

public final class ProductoFactory {

    public static final ProdUnidadService PROD_UNIDAD_SERVICE(Session session) {
        return (ProdUnidadService) new ProdUnidadRepository().setSession(session);
    }

    public static final ProdEstadoService PROD_ESTADO_SERVICE(Session session) {
        return (ProdEstadoService) new ProdEstadoRepository().setSession(session);
    }

    public static final ProdCategoriaService PROD_CATEGORIA_SERVICE(Session session) {
        return (ProdCategoriaService) new ProdCategoriaRepository().setSession(session);
    }

    public static final FamPresentacionService FAM_PRESENTACION_SERVICE(Session session) {
        return (FamPresentacionService) new FamPresentacionRepository().setSession(session);
    }

    public static final FamAdministracionService FAM_ADMINISTRACION_SERVICE(Session session) {
        return (FamAdministracionService) new FamAdministracionRepository().setSession(session);
    }

    public static final FamiliaService FAMILIA_SERVICE(Session session) {
        return (FamiliaService) new FamiliaRepository().setSession(session);
    }

    public static final ConcentracionService CONCENTRACION_SERVICE(Session session) {
        return (ConcentracionService) new ConcentracionRepository().setSession(session);
    }

    public static final PrincipalActivoService PRINCIPAL_ACTIVO_SERVICE(Session session) {
        return (PrincipalActivoService) new PrincipalActivoRepository().setSession(session);
    }
}
