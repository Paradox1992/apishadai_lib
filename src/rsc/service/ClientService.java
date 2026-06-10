package rsc.service;

import com.shapi.model.auth.Session;
import rsc.service.client.CustomerService;

public interface ClientService {

    CustomerService clienteService(Session session);

}
