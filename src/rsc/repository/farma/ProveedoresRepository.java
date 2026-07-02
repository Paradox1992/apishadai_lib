package rsc.repository.farma;

import com.shapi.model.Farma.Proveedores;
import rsc.core.template.repository.GenericRepository;
import rsc.service.farma.ProveedoresService;

public final class ProveedoresRepository extends GenericRepository<Proveedores, Object> implements ProveedoresService {

    public ProveedoresRepository() {
        super(Proveedores.class);
    }

}
