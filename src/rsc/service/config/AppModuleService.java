package rsc.service.config;

import com.shapi.model.AppModule;
import com.shapi.model.AppModuleStatus;
import java.util.List;
import rsc.core.template.service.GenericService;
import rsc.data.Response;

public interface AppModuleService extends GenericService<AppModule, Object> {

    Response<List<AppModuleStatus>> estadosList();
}
