package rsc.service.location;

import com.shapi.model.Municipality;
import java.util.List;
import rsc.core.template.service.GenericService;
import rsc.data.Response;

public interface MunicipalityService extends GenericService<Municipality, Object> {

    Response<List<Municipality>> bydepartamento(Object departamentoId);
}
