package rsc.repository.config;

import com.shapi.model.AppModule;
import com.shapi.model.AppModuleStatus;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import rsc.data.Response;
import rsc.service.config.AppModuleService;
import rsc.util.TypeUtils;

public final class AppModuleRepository extends GenericRepository<AppModule, Object> implements AppModuleService {
    
    public AppModuleRepository() {
        super(AppModule.class);
    }
    
    @Override
    public Response<List<AppModuleStatus>> estadosList() {
        return send(null, TypeUtils.listOf(AppModuleStatus.class));
    }
    
}
