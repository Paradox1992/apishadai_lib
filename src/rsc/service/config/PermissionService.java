package rsc.service.config;

import com.shapi.model.ViewAction;
import com.shapi.model.AppModule;
import com.shapi.model.Permission;
import com.shapi.model.TimeType;
import com.shapi.model.View;
import java.util.List;
import rsc.core.template.service.GenericService;
import rsc.data.Response;

public interface PermissionService extends GenericService<Permission, Object> {

    Response<List<Permission>> listbyUser(Object id);

    Response<List<AppModule>> listModules();

    Response<List<View>> listViewsByModule(Object id);

    Response<List<ViewAction>> listActionsByView(Object id);

    Response<List<TimeType>> listTipoTiempo();

}
