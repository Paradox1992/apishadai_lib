package rsc.factory;

import com.shapi.model.auth.Session;
import rsc.repository.client.CustomerRepository;
import rsc.service.client.CustomerService;

public final class CustomerFactory {

    public static final CustomerService CLIENTE_FACTORY(Session session) {
        return (CustomerService) new CustomerRepository().setSession(session);
    }
}
