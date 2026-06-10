package rsc.repository.promotion;

import com.shapi.model.PromotionStatus;
import rsc.core.template.repository.GenericRepository;
import rsc.service.promotion.PromotionStatusService;


public final class PromotionStatusRepository extends GenericRepository<PromotionStatus, Object> implements PromotionStatusService {

    public PromotionStatusRepository() {
        super(PromotionStatus.class);
    }
}
