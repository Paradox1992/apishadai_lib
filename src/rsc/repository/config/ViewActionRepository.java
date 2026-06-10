package rsc.repository.config;

import com.shapi.model.ViewAction;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import rsc.data.Response;
import rsc.service.config.ViewActionService;
import rsc.util.TypeUtils;

public final class ViewActionRepository extends GenericRepository<ViewAction, Object> implements ViewActionService {

    public ViewActionRepository() {
        super(ViewAction.class);
    }

    @Override
    public Response<List<ViewAction>> findByView(String vistaId) {
        return sendWithParam(vistaId, TypeUtils.listOf(ViewAction.class));
    }

}
