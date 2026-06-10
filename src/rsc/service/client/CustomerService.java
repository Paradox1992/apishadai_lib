package rsc.service.client;

import com.shapi.model.Customer;
import java.util.List;
import rsc.core.template.service.GenericService;
import rsc.data.Response;

public interface CustomerService extends GenericService<Customer, Object> {
    
    Response<List<Customer>> lasts();
    
}
