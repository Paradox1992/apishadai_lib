package rsc.service.farma;

import com.requestsupport.responses.ApiResponse;
import com.shapi.model.Farma.Proveedores;
import com.shapi.model.util.ProveedorImageResponse.ImageData;
import rsc.core.template.service.GenericService;

public interface ProveedoresService extends GenericService<Proveedores, Object> {

    ApiResponse<ImageData> getImage(int id);
}
