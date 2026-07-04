package rsc.repository.client;

import com.shapi.model.Customer;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import com.requestsupport.responses.ApiResponse;
import rsc.service.client.CustomerService;

public final class CustomerRepository extends GenericRepository<Customer, Object> implements CustomerService {

    public CustomerRepository() {
        super(Customer.class);
    }

    @Override
    public ApiResponse<List<Customer>> lasts() {
        return send(null, Customer.class);
    }

}
