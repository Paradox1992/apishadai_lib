package rsc.repository.config;

import com.shapi.model.ViewAction;
import com.shapi.model.View;
import com.shapi.model.ViewStatus;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import rsc.data.Response;
import rsc.service.config.ViewService;
import rsc.util.TypeUtils;

public final class ViewRepository extends GenericRepository<View, String> implements ViewService {
    
    public ViewRepository() {
        super(View.class);
    }
    
    @Override
    public Response<List<ViewAction>> acctionsList(String vid) {
        return sendWithParam(vid, TypeUtils.listOf(ViewAction.class));
    }
    
    @Override
    public Response<List<ViewStatus>> estadosList() {
        return send(null, TypeUtils.listOf(ViewStatus.class));
    }
    
    @Override
    public Response<Boolean> crearAccion(ViewAction accion) {
        return send(null, Boolean.class);
        
    }
    
    @Override
    public Response<Boolean> EliminarAccion(String id) {
        return send(null, Boolean.class);
    }
    
}
