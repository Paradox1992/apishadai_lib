package rsc.Repositores.ReportesRepositories;

import com.shapi.Models.Clientes;
import com.shapi.Models.Promociones;
import com.shapi.Models.Stock;
import com.shapi.Models.Tikets;
import com.shapi.Models.User;
import com.shapi.Models.Utils.FilterModel;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.ReportesServices.TicketReporteService;
import rsc.Utility.TypeUtils;

public class TicketReporteRepository extends GenericRepository<Tikets, Object> implements TicketReporteService {

    public TicketReporteRepository() {
        super(Tikets.class);
    }

    @Override
    public Response<List<Promociones>> filterPromos(FilterModel model) {
        return send(model, TypeUtils.listOf(Promociones.class));
    }

    @Override
    public Response<List<Clientes>> filterClientes(FilterModel model) {
        return send(model, TypeUtils.listOf(Clientes.class));

    }

    @Override
    public Response<List<User>> filterUsuarios(FilterModel model) {
        return send(model, TypeUtils.listOf(User.class));

    }

    @Override
    public Response<List<Stock>> filterStocks(FilterModel model) {
        return send(model, TypeUtils.listOf(Stock.class));

    }

}
