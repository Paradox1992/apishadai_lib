package rsc.repository.config;

import com.shapi.model.AppModuleStatus;
import rsc.core.template.repository.GenericRepository;
import rsc.service.config.AppModuleStatusService;

public final class AppModuleStatusRepository extends GenericRepository<AppModuleStatus, Object> implements AppModuleStatusService {

    public AppModuleStatusRepository() {
        super(AppModuleStatus.class);
    }

}
