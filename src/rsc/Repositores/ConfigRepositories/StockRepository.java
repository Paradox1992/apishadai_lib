package rsc.Repositores.ConfigRepositories;

import com.shapi.Models.Stock;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Services.ConfigServices.StockService;
public final class StockRepository extends GenericRepository<Stock, Object> implements StockService {

    public StockRepository() {
        super(Stock.class);
    }

}
