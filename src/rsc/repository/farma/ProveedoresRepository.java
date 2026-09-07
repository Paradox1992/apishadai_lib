package rsc.repository.farma;

import com.requestsupport.responses.ApiResponse;
import com.shapi.model.Farma.Proveedores;
import com.shapi.model.util.ProveedorImageResponse.ImageData;
import rsc.core.template.repository.GenericRepository;
import rsc.service.farma.ProveedoresService;

public final class ProveedoresRepository extends GenericRepository<Proveedores, Object> implements ProveedoresService {

    public ProveedoresRepository() {
        super(Proveedores.class);
    }

    @Override
    public ApiResponse<ImageData> getImage(int id) {
        return sendWithParam(id, ImageData.class);
    }

}
