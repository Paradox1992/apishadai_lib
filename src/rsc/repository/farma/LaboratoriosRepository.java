package rsc.repository.farma;

import com.requestsupport.responses.ApiResponse;
import com.shapi.model.Farma.Laboratorio;
import com.shapi.model.util.LaboratorioImageResponse.ImageData;
import rsc.core.template.repository.GenericRepository;
import rsc.service.farma.LaboratoriosService;

public final class LaboratoriosRepository extends GenericRepository<Laboratorio, Object> implements LaboratoriosService {

    public LaboratoriosRepository() {
        super(Laboratorio.class);
    }

    @Override
    public ApiResponse<ImageData> getImage(int id) {
        return sendWithParam(id, ImageData.class);
    }

}
