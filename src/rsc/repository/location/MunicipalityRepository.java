package rsc.repository.location;

import com.shapi.model.Municipality;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import com.requestsupport.responses.ApiResponse;
import rsc.service.location.MunicipalityService;


public final class MunicipalityRepository extends GenericRepository<Municipality, Object> implements MunicipalityService {

    public MunicipalityRepository() {
        super(Municipality.class);
    }

    @Override
    public ApiResponse<List<Municipality>> bydepartamento(Object departamentoId) {
        return sendWithParam(departamentoId, Municipality.class);
    }

}
