package rsc.repository.config;

import com.shapi.model.ViewAction;
import com.shapi.model.AppModule;
import com.shapi.model.Permission;
import com.shapi.model.TimeType;
import com.shapi.model.View;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import com.requestsupport.responses.ApiResponse;
import rsc.service.config.PermissionService;
import rsc.util.TypeUtils;

public final class PermissionRepository extends GenericRepository<Permission, Object> implements PermissionService {

    public PermissionRepository() {
        super(Permission.class);
    }

    @Override
    public ApiResponse<List<Permission>> listbyUser(Object id) {
        return sendWithParam(id, TypeUtils.listOf(Permission.class));
    }

    @Override
    public ApiResponse<List<AppModule>> listModules() {
        return send(null, TypeUtils.listOf(AppModule.class));
    }

    @Override
    public ApiResponse<List<View>> listViewsByModule(Object id) {
        return sendWithParam(id, TypeUtils.listOf(View.class));
    }

    @Override
    public ApiResponse<List<ViewAction>> listActionsByView(Object id) {
        return sendWithParam(id, TypeUtils.listOf(ViewAction.class));
    }

    @Override
    public ApiResponse<List<TimeType>> listTipoTiempo() {
        return send(null, TypeUtils.listOf(TimeType.class));
    }

}
