package rsc.service.farma;

import com.requestsupport.responses.ApiResponse;
import com.shapi.model.Farma.FamAdministracion;
import com.shapi.model.Farma.FamPresentacion;
import com.shapi.model.Farma.Familia;
import java.util.List;
import rsc.core.template.service.GenericService;

public interface FamiliaService extends GenericService<Familia, Object> {

    ApiResponse<List<FamPresentacion>> presentacionList();

    ApiResponse<List<FamAdministracion>> administracionList();

}
