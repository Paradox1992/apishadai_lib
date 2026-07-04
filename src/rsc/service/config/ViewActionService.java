package rsc.service.config;

import com.shapi.model.ViewAction;
import java.util.List;
import rsc.core.template.service.GenericService;
import com.requestsupport.responses.ApiResponse;

public interface ViewActionService extends GenericService<ViewAction, Object> {

    ApiResponse<List<ViewAction>> findByView(String vistaId);
    
}
