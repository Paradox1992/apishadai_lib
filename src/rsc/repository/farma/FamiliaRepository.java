package rsc.repository.farma;

import com.requestsupport.responses.ApiResponse;
import com.shapi.model.Farma.FamAdministracion;
import com.shapi.model.Farma.FamPresentacion;
import com.shapi.model.Farma.Familia;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import rsc.service.farma.FamiliaService;
import rsc.util.TypeUtils;

public final class FamiliaRepository extends GenericRepository<Familia, Object> implements FamiliaService {

    public FamiliaRepository() {
        super(Familia.class);
    }

    @Override
    public ApiResponse<List<FamPresentacion>> presentacionList() {
        return send(null, TypeUtils.listOf(FamPresentacion.class));
    }

    @Override
    public ApiResponse<List<FamAdministracion>> administracionList() {
        return send(null, TypeUtils.listOf(FamAdministracion.class));

    }

}
