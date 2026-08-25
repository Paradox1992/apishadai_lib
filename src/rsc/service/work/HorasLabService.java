package rsc.service.work;

import com.shapi.model.HorasLab;
import com.requestsupport.responses.ApiResponse;
import rsc.core.template.service.GenericService;

public interface HorasLabService extends GenericService<HorasLab, Object> {

    ApiResponse<HorasLab> findByUser(Object userId);
}
