package rsc.repository.promotion;

import com.shapi.model.PromotionStatus;
import com.shapi.model.Promotion;
import com.shapi.model.util.FilterModel;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import rsc.data.Response;
import rsc.service.promotion.PromotionCatalogService;
import rsc.util.TypeUtils;

public final class PromotionRepository extends GenericRepository<Promotion, Object> implements PromotionCatalogService {

    public PromotionRepository() {
        super(Promotion.class);
    }

    @Override
    public Response<List<Promotion>> filter(FilterModel filter) {
        return send(filter, TypeUtils.listOf(Promotion.class));
    }

    @Override
    public Response<List<PromotionStatus>> estadosList() {
        return send(null, TypeUtils.listOf(PromotionStatus.class));
    }
}
