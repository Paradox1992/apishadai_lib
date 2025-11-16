package rsc.Repositores.UbicacionRepositories;

import com.shapi.Models.Municipios;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.UbicacionServices.MunicipiosService;
import rsc.Utility.TypeUtils;

public final class MunicipiosRepository extends GenericRepository<Municipios, Object> implements MunicipiosService {

    public MunicipiosRepository() {
        super(Municipios.class);
    }

    @Override
    public Response<List<Municipios>> bydepartamento(Object departamentoId) {
        return sendWithParam(departamentoId, TypeUtils.of(Municipios.class));
    }

}
