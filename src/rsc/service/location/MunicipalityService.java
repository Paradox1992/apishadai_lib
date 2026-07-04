package rsc.service.location;

import com.shapi.model.Municipality;
import java.util.List;
import rsc.core.template.service.GenericService;
import com.requestsupport.responses.ApiResponse;

public interface MunicipalityService extends GenericService<Municipality, Object> {

    ApiResponse<List<Municipality>> bydepartamento(Object departamentoId);
}
