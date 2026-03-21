package rsc.Services.ConfigServices;

import com.shapi.Models.Stock;
import com.shapi.Models.StockEstado;
import java.util.List;
import rsc.Core.Templates.Service.GenericService;
import rsc.Data.Response;

public interface StockService extends GenericService<Stock, Object> {

    Response<List<StockEstado>> estadosList();
}
