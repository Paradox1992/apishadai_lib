package rsc.repository.location;

import com.shapi.model.Municipality;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import rsc.data.Response;
import rsc.service.location.MunicipalityService;


public final class MunicipalityRepository extends GenericRepository<Municipality, Object> implements MunicipalityService {

    public MunicipalityRepository() {
        super(Municipality.class);
    }

    @Override
    public Response<List<Municipality>> bydepartamento(Object departamentoId) {
        return sendWithParam(departamentoId, Municipality.class);
    }

}
