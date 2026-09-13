package rsc.repository.farma;

import com.shapi.model.Farma.FamAdministracion;
import rsc.core.template.repository.GenericRepository;
import rsc.service.farma.FamAdministracionService;

public final class FamAdministracionRepository extends GenericRepository<FamAdministracion, Object> implements FamAdministracionService {

    public FamAdministracionRepository() {
        super(FamAdministracion.class);
    }

}
