package rsc.repository.promotion;

import com.shapi.model.Customer;
import com.shapi.model.Department;
import com.shapi.model.Municipality;
import com.shapi.model.Promotion;
import com.shapi.model.Ticket;
import com.shapi.model.util.Base64File;
import com.shapi.model.util.FilterModel;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import rsc.data.Response;
import rsc.service.promotion.TicketService;
import rsc.util.TypeUtils;

public final class TicketRepository extends GenericRepository<Ticket, Object> implements TicketService {

    public TicketRepository() {
        super(Ticket.class);

    }

    @Override
    public Response<Base64File> generateTicket(Ticket tiket) {
        return send(tiket, Base64File.class);
    }

    @Override
    public Response<Boolean> create(Ticket entity) {
        return super.create(entity);
    }

    @Override
    public Response<List<Customer>> listCustomers() {
        return send(null, TypeUtils.listOf(Customer.class));
    }

    @Override
    public Response<List<Customer>> filterCustomers(FilterModel filter) {
        return send(filter, TypeUtils.listOf(Customer.class));
    }

    @Override
    public Response<Boolean> createCustomer(Customer cliente) {
        return send(cliente, Boolean.class);
    }

    @Override
    public Response<Boolean> updateCustomerPhone(Customer cliente) {
        return send(cliente, Boolean.class);

    }

    @Override
    public Response<Boolean> isPhoneActive(int id) {
        return sendWithParam(id, Boolean.class);

    }

    @Override
    public Response<List<Department>> listDepartments() {
        return send(null, TypeUtils.listOf(Department.class));
    }

    @Override
    public Response<List<Municipality>> municipalities(int departamentoId) {
        return sendWithParam(departamentoId, TypeUtils.listOf(Municipality.class));

    }

    @Override
    public Response<Promotion> activePromotion() {
        return send(null, Promotion.class);
    }

}
