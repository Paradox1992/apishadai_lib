package rsc.repository.work;

import com.shapi.model.HorasLab;
import com.requestsupport.responses.ApiResponse;
import rsc.core.template.repository.GenericRepository;
import rsc.service.work.HorasLabService;

public final class HorasLabRepository extends GenericRepository<HorasLab, Object> implements HorasLabService {

    public HorasLabRepository() {
        super(HorasLab.class);
    }

    @Override
    public ApiResponse<HorasLab> findByUser(Object userId) {
        return sendWithParam(userId, HorasLab.class);
    }
}
