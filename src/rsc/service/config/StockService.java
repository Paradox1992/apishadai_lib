package rsc.service.config;

import com.shapi.model.Stock;
import com.shapi.model.StockStatus;
import java.util.List;
import rsc.core.template.service.GenericService;
import rsc.data.Response;

public interface StockService extends GenericService<Stock, Object> {

    Response<List<StockStatus>> estadosList();
}
