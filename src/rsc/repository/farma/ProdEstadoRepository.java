package rsc.repository.farma;

import com.shapi.model.Farma.ProdEstado;
import rsc.core.template.repository.GenericRepository;
import rsc.service.farma.ProdEstadoService;

public final class ProdEstadoRepository extends GenericRepository<ProdEstado, Object> implements ProdEstadoService {

    public ProdEstadoRepository() {
        super(ProdEstado.class);
    }

}
