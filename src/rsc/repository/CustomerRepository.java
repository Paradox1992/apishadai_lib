package rsc.repository;

import com.shapi.model.auth.Session;
import rsc.factory.CustomerFactory;
import rsc.service.ClientService;
import rsc.service.client.CustomerService;

public class CustomerRepository implements ClientService {

    @Override
    public CustomerService clienteService(Session session) {
        return CustomerFactory.CLIENTE_FACTORY(session);
    }

}
