package rsc.Repositores.ClientesRepository;

import com.shapi.Models.Clientes;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.ClientesServices.ClientesService;

public final class ClienteRepository extends GenericRepository<Clientes, Object> implements ClientesService {

    public ClienteRepository() {
        super(Clientes.class);
    }

    @Override
    public Response<List<Clientes>> lasts() {
        return send(null, Clientes.class);
    }

}
