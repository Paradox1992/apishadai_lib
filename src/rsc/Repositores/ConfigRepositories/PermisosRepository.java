package rsc.Repositores.ConfigRepositories;

import com.shapi.Models.Actionsvistas;
import com.shapi.Models.Modulo;
import com.shapi.Models.Permisos;
import com.shapi.Models.TiposTiempo;
import com.shapi.Models.Vista;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.ConfigServices.PermisosService;

public final class PermisosRepository extends GenericRepository<Permisos, Object> implements PermisosService {

    public PermisosRepository() {
        super(Permisos.class);
    }

    @Override
    public Response<List<Permisos>> listbyUser(Object id) {
        return sendWithParam(id, Permisos.class);
    }

    @Override
    public Response<List<Modulo>> listModulos() {
        return send(null, Modulo.class);
    }

    @Override
    public Response<List<Vista>> listVistasbyModulo(Object id) {
        return sendWithParam(id, Vista.class);
    }

    @Override
    public Response<List<Actionsvistas>> accionsbyVista(Object id) {
        return sendWithParam(id, Actionsvistas.class);
    }

    @Override
    public Response<List<TiposTiempo>> listTipoTiempo() {
        return send(null, TiposTiempo.class);
    }

}
