package rsc.repository.config;

import com.shapi.model.Stock;
import com.shapi.model.StockStatus;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import rsc.data.Response;
import rsc.service.config.StockService;
import rsc.util.TypeUtils;

public final class StockRepository extends GenericRepository<Stock, Object> implements StockService {

    public StockRepository() {
        super(Stock.class);
    }

    @Override
    public Response<List<StockStatus>> estadosList() {
        return send(null, TypeUtils.listOf(StockStatus.class));
    }

}
