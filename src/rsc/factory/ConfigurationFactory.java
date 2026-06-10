package rsc.factory;

import com.shapi.model.auth.Session;
import rsc.repository.config.ViewActionRepository;
import rsc.repository.config.DeviceRepository;
import rsc.repository.config.AppModuleRepository;
import rsc.repository.config.PermissionRepository;
import rsc.repository.config.RoleRepository;
import rsc.repository.config.StockRepository;
import rsc.repository.config.UserRepository;
import rsc.repository.config.ViewRepository;
import rsc.service.config.ViewActionService;
import rsc.service.config.DeviceService;
import rsc.service.config.AppModuleService;
import rsc.service.config.PermissionService;
import rsc.service.config.RoleService;
import rsc.service.config.StockService;
import rsc.service.config.UserService;
import rsc.service.config.ViewService;

public final class ConfigurationFactory {

    public static final RoleService ROL_SERVICE(Session session) {
        return (RoleService) new RoleRepository().setSession(session);
    }

    public static final UserService USER_SERVICE(Session session) {
        return (UserService) new UserRepository().setSession(session);
    }

    public static final PermissionService PERMISOS_SERVICE(Session session) {
        return (PermissionService) new PermissionRepository().setSession(session);
    }

    public static final ViewService VISTA_SERVICE(Session session) {
        return (ViewService) new ViewRepository().setSession(session);
    }

    public static final DeviceService DEVICE_SERVICE(Session session) {
        return (DeviceService) new DeviceRepository().setSession(session);
    }

    public static final AppModuleService MODULO_SERVICE(Session session) {
        return (AppModuleService) new AppModuleRepository().setSession(session);
    }

    public static final StockService STOCK_SERVICE(Session session) {
        return (StockService) new StockRepository().setSession(session);
    }

    public static final ViewActionService ACTIONVISTA_SERVICE(Session session) {
        return (ViewActionService) new ViewActionRepository().setSession(session);
    }
}
