package rsc.Repositores;

import com.shapi.Models.auth.Session;
import rsc.Factories.ClienteFactory;
import rsc.Services.ClienteService;
import rsc.Services.ClientesServices.ClientesService;

public class ClienteRepository implements ClienteService {

    @Override
    public ClientesService clienteService(Session session) {
        return ClienteFactory.CLIENTE_SERVICE(session);
    }

}
