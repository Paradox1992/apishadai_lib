package rsc.Repositores.ConfigRepositories;

import com.shapi.Models.Stock;
import com.shapi.Models.StockEstado;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.ConfigServices.StockService;
import rsc.Utility.TypeUtils;

public final class StockRepository extends GenericRepository<Stock, Object> implements StockService {

    public StockRepository() {
        super(Stock.class);
    }

    @Override
    public Response<List<StockEstado>> estadosList() {
        return send(null, TypeUtils.listOf(StockEstado.class));
    }

}
