package rsc.service.config;

import com.shapi.model.ViewAction;
import com.shapi.model.AppModule;
import com.shapi.model.Permission;
import com.shapi.model.TimeType;
import com.shapi.model.View;
import java.util.List;
import rsc.core.template.service.GenericService;
import com.requestsupport.responses.ApiResponse;

public interface PermissionService extends GenericService<Permission, Object> {

    ApiResponse<List<Permission>> listbyUser(Object id);

    ApiResponse<List<AppModule>> listModules();

    ApiResponse<List<View>> listViewsByModule(Object id);

    ApiResponse<List<ViewAction>> listActionsByView(Object id);

    ApiResponse<List<TimeType>> listTipoTiempo();

}
