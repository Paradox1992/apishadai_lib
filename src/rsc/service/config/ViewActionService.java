package rsc.service.config;

import com.shapi.model.ViewAction;
import java.util.List;
import rsc.core.template.service.GenericService;
import rsc.data.Response;

public interface ViewActionService extends GenericService<ViewAction, Object> {

    Response<List<ViewAction>> findByView(String vistaId);
    
}
