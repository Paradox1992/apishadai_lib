package rsc.repository.client;

import com.shapi.model.Customer;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import rsc.data.Response;
import rsc.service.client.CustomerService;

public final class CustomerRepository extends GenericRepository<Customer, Object> implements CustomerService {

    public CustomerRepository() {
        super(Customer.class);
    }

    @Override
    public Response<List<Customer>> lasts() {
        return send(null, Customer.class);
    }

}
