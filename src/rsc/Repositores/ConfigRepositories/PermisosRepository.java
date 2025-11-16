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
import rsc.Utility.TypeUtils;

public final class PermisosRepository extends GenericRepository<Permisos, Object> implements PermisosService {

    public PermisosRepository() {
        super(Permisos.class);
    }

    @Override
    public Response<List<Permisos>> listbyUser(Object id) {
        return sendWithParam(id, TypeUtils.of(Permisos.class));
    }

    @Override
    public Response<List<Modulo>> listModulos() {
        return send(null, TypeUtils.of(Modulo.class));
    }

    @Override
    public Response<List<Vista>> listVistasbyModulo(Object id) {
        return sendWithParam(id, TypeUtils.of(Vista.class));
    }

    @Override
    public Response<List<Actionsvistas>> accionsbyVista(Object id) {
        return sendWithParam(id, TypeUtils.of(Actionsvistas.class));
    }

    @Override
    public Response<List<TiposTiempo>> listTipoTiempo() {
        return send(null, TypeUtils.of(TiposTiempo.class));
    }

}
