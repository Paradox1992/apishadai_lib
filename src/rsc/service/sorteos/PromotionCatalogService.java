package rsc.service.sorteos;

import com.shapi.model.PromotionStatus;
import com.shapi.model.Promotion;
import com.shapi.model.util.FilterModel;
import java.util.List;
import rsc.core.template.service.GenericService;
import com.requestsupport.responses.ApiResponse;

public interface PromotionCatalogService extends GenericService<Promotion, Object> {

    ApiResponse<List<Promotion>> filter(FilterModel filter);

    ApiResponse<List<PromotionStatus>> estadosList();

}
