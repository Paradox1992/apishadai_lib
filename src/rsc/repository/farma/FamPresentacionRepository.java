package rsc.repository.farma;

import com.shapi.model.Farma.FamPresentacion;
import rsc.core.template.repository.GenericRepository;
import rsc.service.farma.FamPresentacionService;

public final class FamPresentacionRepository extends GenericRepository<FamPresentacion, Object> implements FamPresentacionService {

    public FamPresentacionRepository() {
        super(FamPresentacion.class);
    }

}
