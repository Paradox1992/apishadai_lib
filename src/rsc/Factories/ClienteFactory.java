package rsc.Factories;

import com.shapi.Models.auth.Session;
import rsc.Repositores.ClientesRepository.ClienteRepository;
import rsc.Services.ClientesServices.ClientesService;

public final class ClienteFactory {

    public static final ClientesService CLIENTE_SERVICE(Session session) {
        return (ClientesService) new ClienteRepository().setSession(session);
    }
}
