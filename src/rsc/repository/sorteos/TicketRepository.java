package rsc.repository.sorteos;

import com.shapi.model.Customer;
import com.shapi.model.Department;
import com.shapi.model.Municipality;
import com.shapi.model.Promotion;
import com.shapi.model.Ticket;
import com.shapi.model.util.FilterModel;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import com.requestsupport.responses.ApiResponse;
import com.shapi.model.TicketRequest;
import rsc.service.sorteos.TicketService;
import rsc.util.TypeUtils;

public final class TicketRepository extends GenericRepository<Ticket, Object> implements TicketService {

    public TicketRepository() {
        super(Ticket.class);

    }

    @Override
    public ApiResponse<TicketRequest> generateTicket(Ticket tiket) {
        return send(tiket, TicketRequest.class);
    }

    @Override
    public ApiResponse<TicketRequest> generateTicket(Ticket tiket, String idempotencyKey) {
        return send(tiket, TicketRequest.class, idempotencyKey);
    }

    @Override
    public ApiResponse<Boolean> create(Ticket entity) {
        return super.create(entity);
    }

    @Override
    public ApiResponse<List<Customer>> listCustomers() {
        return send(null, TypeUtils.listOf(Customer.class));
    }

    @Override
    public ApiResponse<List<Customer>> filterCustomers(FilterModel filter) {
        return send(filter, TypeUtils.listOf(Customer.class));
    }

    @Override
    public ApiResponse<Boolean> createCustomer(Customer cliente) {
        return send(cliente, Boolean.class);
    }

    @Override
    public ApiResponse<Boolean> createCustomer(Customer cliente, String idempotencyKey) {
        return send(cliente, Boolean.class, idempotencyKey);
    }

    @Override
    public ApiResponse<Boolean> updateCustomerPhone(Customer cliente) {
        return send(cliente, Boolean.class);

    }

    @Override
    public ApiResponse<Boolean> updateCustomerPhone(Customer cliente, String idempotencyKey) {
        return send(cliente, Boolean.class, idempotencyKey);

    }

    @Override
    public ApiResponse<Boolean> isPhoneActive(int id) {
        return sendWithParam(id, Boolean.class);

    }

    @Override
    public ApiResponse<List<Department>> listDepartments() {
        return send(null, TypeUtils.listOf(Department.class));
    }

    @Override
    public ApiResponse<List<Municipality>> municipalities(int departamentoId) {
        return sendWithParam(departamentoId, TypeUtils.listOf(Municipality.class));

    }

    @Override
    public ApiResponse<Promotion> activePromotion() {
        return send(null, Promotion.class);
    }

}
