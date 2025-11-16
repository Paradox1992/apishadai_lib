package rsc.Repositores.ConfigRepositories;

import com.shapi.Models.Vista;
import com.shapi.Models.VistaEstado;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.ConfigServices.VistaService;
import rsc.Utility.TypeUtils;

public final class VistaRepository extends GenericRepository<Vista, String> implements VistaService {

    public VistaRepository() {
        super(Vista.class);
    }

    @Override
    public Response<List<Vista>> findbyModulo(String mid) {
        return sendWithParam(mid, TypeUtils.of(Vista.class));
    }

    @Override
    public Response<List<VistaEstado>> estadosList() {
        return send(null, TypeUtils.of(VistaEstado.class));
    }

}
