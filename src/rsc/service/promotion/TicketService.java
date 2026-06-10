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
import rsc.data.Response;

public interface TicketService extends GenericService<Ticket, Object> {

    Response<Base64File> generateTicket(Ticket tiket);

    Response<List<Customer>> listCustomers();

    Response<List<Customer>> filterCustomers(FilterModel filter);

    Response<Boolean> createCustomer(Customer cliente);

    Response<Boolean> updateCustomerPhone(Customer cliente);

    Response<Boolean> isPhoneActive(int id);

    Response<List<Department>> listDepartments();

    Response<List<Municipality>> municipalities(int departamentoId);

    Response<Promotion> activePromotion();
}
