package rsc.service.farma;

import com.shapi.model.auth.Session;

public interface ProductoService {

    ProdUnidadService prodUnidadService(Session session);

    ProdEstadoService prodEstadoService(Session session);

    ProdCategoriaService prodCategoriaService(Session session);

    FamPresentacionService famPresentacionService(Session session);

    FamAdministracionService famAdministracionService(Session session);

    FamiliaService familiaService(Session session);

    ConcentracionService concentracionService(Session session);

    PrincipalActivoService principalActivoService(Session session);

}
