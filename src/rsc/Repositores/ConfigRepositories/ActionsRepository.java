package rsc.Repositores.ConfigRepositories;

import com.shapi.Models.Actionsvistas;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.ConfigServices.ActionsVistaService;
import rsc.Utility.TypeUtils;

public final class ActionsRepository extends GenericRepository<Actionsvistas, Object> implements ActionsVistaService {

    public ActionsRepository() {
        super(Actionsvistas.class);
    }

    @Override
    public Response<List<Actionsvistas>> findbyVista(String vistaId) {
        return sendWithParam(vistaId, TypeUtils.of(Actionsvistas.class));
    }

}
