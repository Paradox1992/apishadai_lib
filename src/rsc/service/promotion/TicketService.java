package rsc.service.promotion;

import com.shapi.model.Customer;
import com.shapi.model.Department;
import com.shapi.model.Municipality;
import com.shapi.model.Promotion;
import com.shapi.model.Ticket;
import com.shapi.model.util.Base64File;
import com.shapi.model.util.FilterModel;
import java.util.List;
import rsc.core.template.service.GenericService;
import com.requestsupport.responses.ApiResponse;

public interface TicketService extends GenericService<Ticket, Object> {

    ApiResponse<Base64File> generateTicket(Ticket tiket);

    ApiResponse<List<Customer>> listCustomers();

    ApiResponse<List<Customer>> filterCustomers(FilterModel filter);

    ApiResponse<Boolean> createCustomer(Customer cliente);

    ApiResponse<Boolean> updateCustomerPhone(Customer cliente);

    ApiResponse<Boolean> isPhoneActive(int id);

    ApiResponse<List<Department>> listDepartments();

    ApiResponse<List<Municipality>> municipalities(int departamentoId);

    ApiResponse<Promotion> activePromotion();
}
