package rsc.repository.config;

import com.shapi.model.ViewAction;
import com.shapi.model.AppModule;
import com.shapi.model.Permission;
import com.shapi.model.TimeType;
import com.shapi.model.View;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import rsc.data.Response;
import rsc.service.config.PermissionService;
import rsc.util.TypeUtils;

public final class PermissionRepository extends GenericRepository<Permission, Object> implements PermissionService {

    public PermissionRepository() {
        super(Permission.class);
    }

    @Override
    public Response<List<Permission>> listbyUser(Object id) {
        return sendWithParam(id, TypeUtils.listOf(Permission.class));
    }

    @Override
    public Response<List<AppModule>> listModules() {
        return send(null, TypeUtils.listOf(AppModule.class));
    }

    @Override
    public Response<List<View>> listViewsByModule(Object id) {
        return sendWithParam(id, TypeUtils.listOf(View.class));
    }

    @Override
    public Response<List<ViewAction>> listActionsByView(Object id) {
        return sendWithParam(id, TypeUtils.listOf(ViewAction.class));
    }

    @Override
    public Response<List<TimeType>> listTipoTiempo() {
        return send(null, TypeUtils.listOf(TimeType.class));
    }

}
