package rsc.service.sorteos;

import com.shapi.model.Customer;
import com.shapi.model.Department;
import com.shapi.model.Municipality;
import com.shapi.model.Promotion;
import com.shapi.model.Ticket;
import com.shapi.model.util.FilterModel;
import java.util.List;
import rsc.core.template.service.GenericService;
import com.requestsupport.responses.ApiResponse;
import com.shapi.model.TicketRequest;

public interface TicketService extends GenericService<Ticket, Object> {

    ApiResponse<TicketRequest> generateTicket(Ticket tiket);

    ApiResponse<TicketRequest> generateTicket(Ticket tiket, String idempotencyKey);

    ApiResponse<List<Customer>> listCustomers();

    ApiResponse<List<Customer>> filterCustomers(FilterModel filter);

    ApiResponse<Boolean> createCustomer(Customer cliente);

    ApiResponse<Boolean> createCustomer(Customer cliente, String idempotencyKey);

    ApiResponse<Boolean> updateCustomerPhone(Customer cliente);

    ApiResponse<Boolean> updateCustomerPhone(Customer cliente, String idempotencyKey);

    ApiResponse<Boolean> isPhoneActive(int id);

    ApiResponse<List<Department>> listDepartments();

    ApiResponse<List<Municipality>> municipalities(int departamentoId);

    ApiResponse<Promotion> activePromotion();
}
