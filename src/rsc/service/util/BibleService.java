package rsc.service.util;

import com.requestsupport.responses.ApiResponse;
import com.shapi.model.util.Biblia;
import rsc.core.template.service.GenericService;

public interface BibleService extends GenericService<Biblia, Object> {
    ApiResponse<Biblia> getRandom();
}
