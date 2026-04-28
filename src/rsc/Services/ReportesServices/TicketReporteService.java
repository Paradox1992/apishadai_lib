package rsc.Services.ReportesServices;

import com.shapi.Models.Clientes;
import com.shapi.Models.Promociones;
import com.shapi.Models.Stock;
import com.shapi.Models.Tikets;
import com.shapi.Models.User;
import com.shapi.Models.Utils.FilterModel;
import java.util.List;
import rsc.Core.Templates.Service.GenericService;
import rsc.Data.Response;

public interface TicketReporteService extends GenericService<Tikets, Object> {

    Response<List<Promociones>> filterPromos(FilterModel model);

    Response<List<Clientes>> filterClientes(FilterModel model);

    Response<List<User>> filterUsuarios(FilterModel model);

    Response<List<Stock>> filterStocks(FilterModel model);

}
