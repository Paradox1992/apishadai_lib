package rsc.Repositores.ClientesRepository;

import com.shapi.Models.Clientes;
import com.shapi.Models.Utils.FilterModel;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Utility.TypeUtils;
import rsc.Services.ClientesServices.ClientesService;

public final class ClienteRepository extends GenericRepository<Clientes, Object> implements ClientesService {

    public ClienteRepository() {
        super(Clientes.class);
    }

    @Override
    public Response<List<Clientes>> lasts() {
        return send(null, TypeUtils.of(Clientes.class));
    }

    @Override
    public Response<List<Clientes>> filter(FilterModel filter) {
        return send(filter, TypeUtils.of(Clientes.class));
    }

}
