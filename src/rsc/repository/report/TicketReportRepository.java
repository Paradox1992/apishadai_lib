package rsc.repository.report;

import com.shapi.model.Customer;
import com.shapi.model.Promotion;
import com.shapi.model.Stock;
import com.shapi.model.Ticket;
import com.shapi.model.User;
import com.shapi.model.util.FilterModel;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import com.requestsupport.responses.ApiResponse;
import rsc.service.report.TicketReportService;
import rsc.util.TypeUtils;

public class TicketReportRepository extends GenericRepository<Ticket, Object> implements TicketReportService {

    public TicketReportRepository() {
        super(Ticket.class);
    }

    @Override
    public ApiResponse<List<Customer>> filterCustomers(FilterModel model) {
        
        return send(model, TypeUtils.listOf(Customer.class));
    }

    @Override
    public ApiResponse<List<User>> filterUsuarios(FilterModel model) {
        return send(model, TypeUtils.listOf(User.class));
    }

    @Override
    public ApiResponse<List<Stock>> filterStocks(FilterModel model) {
        return send(model, TypeUtils.listOf(Stock.class));
    }

    @Override
    public ApiResponse<List<Promotion>> listRaffles( ) {
        return send(null, TypeUtils.listOf(Promotion.class));
    }

    @Override
    public ApiResponse<List<Customer>> listCustomers( ) {
        return send(null, TypeUtils.listOf(Customer.class));
    }

    @Override
    public ApiResponse<List<Stock>> listStocks( ) {
        return send(null, TypeUtils.listOf(Stock.class));
    }

    @Override
    public ApiResponse<List<User>> listUsuarios( ) {
        return send(null, TypeUtils.listOf(User.class));
    }

}
