package rsc.service.farma;

import com.requestsupport.responses.ApiResponse;
import com.shapi.model.Farma.Laboratorio;
import com.shapi.model.util.LaboratorioImageResponse.ImageData;
import rsc.core.template.service.GenericService;

public interface LaboratoriosService extends GenericService<Laboratorio, Object> {

    ApiResponse<ImageData> getImage(int id);
}
