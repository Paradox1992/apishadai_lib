package rsc.service.report;

import com.shapi.model.Customer;
import com.shapi.model.Promotion;
import com.shapi.model.Stock;
import com.shapi.model.Ticket;
import com.shapi.model.User;
import com.shapi.model.util.FilterModel;
import java.util.List;
import rsc.core.template.service.GenericService;
import com.requestsupport.responses.ApiResponse;

public interface TicketReportService extends GenericService<Ticket, Object> {

    ApiResponse<List<Customer>> filterCustomers(FilterModel model);

    ApiResponse<List<User>> filterUsuarios(FilterModel model);

    ApiResponse<List<Stock>> filterStocks(FilterModel model);

    ApiResponse<List<Promotion>> listRaffles();

    ApiResponse<List<Customer>> listCustomers();

    ApiResponse<List<Stock>> listStocks();

    ApiResponse<List<User>> listUsuarios();

}
