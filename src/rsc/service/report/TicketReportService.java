package rsc.service.report;

import com.shapi.model.Customer;
import com.shapi.model.Promotion;
import com.shapi.model.Stock;
import com.shapi.model.Ticket;
import com.shapi.model.User;
import com.shapi.model.util.FilterModel;
import java.util.List;
import rsc.core.template.service.GenericService;
import rsc.data.Response;

public interface TicketReportService extends GenericService<Ticket, Object> {

    Response<List<Customer>> filterCustomers(FilterModel model);

    Response<List<User>> filterUsuarios(FilterModel model);

    Response<List<Stock>> filterStocks(FilterModel model);

    Response<List<Promotion>> listRaffles();

    Response<List<Customer>> listCustomers();

    Response<List<Stock>> listStocks();

    Response<List<User>> listUsuarios();

}
