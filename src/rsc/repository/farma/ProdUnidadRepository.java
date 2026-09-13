package rsc.repository.farma;

import com.shapi.model.Farma.ProdUnidad;
import rsc.core.template.repository.GenericRepository;
import rsc.service.farma.ProdUnidadService;

public final class ProdUnidadRepository extends GenericRepository<ProdUnidad, Object> implements ProdUnidadService {

    public ProdUnidadRepository() {
        super(ProdUnidad.class);
    }

}
