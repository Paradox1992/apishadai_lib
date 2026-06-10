package rsc.service.promotion;

import com.shapi.model.PromotionStatus;
import com.shapi.model.Promotion;
import com.shapi.model.util.FilterModel;
import java.util.List;
import rsc.core.template.service.GenericService;
import rsc.data.Response;

public interface PromotionCatalogService extends GenericService<Promotion, Object> {

    Response<List<Promotion>> filter(FilterModel filter);

    Response<List<PromotionStatus>> estadosList();

}
