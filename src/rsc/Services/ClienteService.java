package rsc.Services;

import com.shapi.Models.auth.Session;
import rsc.Services.ClientesServices.ClientesService;

public interface ClienteService {

    ClientesService clienteService(Session session);

}
