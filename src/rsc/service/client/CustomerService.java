package rsc.service.client;

import com.shapi.model.Customer;
import com.requestsupport.responses.ApiResponse;
import java.util.List;
import rsc.core.template.service.GenericService;


public interface CustomerService extends GenericService<Customer, Object> {
    
    ApiResponse<List<Customer>> lasts();
    
}
