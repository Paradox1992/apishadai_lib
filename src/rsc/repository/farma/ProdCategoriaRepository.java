package rsc.repository.farma;

import com.shapi.model.Farma.ProdCategoria;
import rsc.core.template.repository.GenericRepository;
import rsc.service.farma.ProdCategoriaService;

public final class ProdCategoriaRepository extends GenericRepository<ProdCategoria, Object> implements ProdCategoriaService {

    public ProdCategoriaRepository() {
        super(ProdCategoria.class);
    }

}
