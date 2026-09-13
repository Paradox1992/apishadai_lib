package rsc.repository.farma;

import com.shapi.model.Farma.PrincipalActivo;
import rsc.core.template.repository.GenericRepository;
import rsc.service.farma.PrincipalActivoService;

public final class PrincipalActivoRepository extends GenericRepository<PrincipalActivo, Object> implements PrincipalActivoService {

    public PrincipalActivoRepository() {
        super(PrincipalActivo.class);
    }

}
