package rsc.repository.farma;

import com.shapi.model.Farma.Concentracion;
import rsc.core.template.repository.GenericRepository;
import rsc.service.farma.ConcentracionService;

public final class ConcentracionRepository extends GenericRepository<Concentracion, Object> implements ConcentracionService {

    public ConcentracionRepository() {
        super(Concentracion.class);
    }

}
