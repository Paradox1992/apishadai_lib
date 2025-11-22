package rsc.Repositores.ConfigRepositories;

import com.shapi.Models.Modulo;
import com.shapi.Models.ModuloEstados;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.ConfigServices.ModuloService;

public final class ModuloRepository extends GenericRepository<Modulo, Object> implements ModuloService {

    public ModuloRepository() {
        super(Modulo.class);
    }

    @Override
    public Response<List<ModuloEstados>> estadosList() {
        return send(null, ModuloEstados.class);
    }

}
