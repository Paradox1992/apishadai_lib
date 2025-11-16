package rsc.Factories;

import com.shapi.Models.auth.Session;
import rsc.Repositores.ConfigRepositories.ActionsRepository;
import rsc.Repositores.ConfigRepositories.DeviceRepository;
import rsc.Repositores.ConfigRepositories.ModuloRepository;
import rsc.Repositores.ConfigRepositories.PermisosRepository;
import rsc.Repositores.ConfigRepositories.RolesRepository;
import rsc.Repositores.ConfigRepositories.StockRepository;
import rsc.Repositores.ConfigRepositories.UserRepository;
import rsc.Repositores.ConfigRepositories.VistaRepository;
import rsc.Services.ConfigServices.ActionsVistaService;
import rsc.Services.ConfigServices.DeviceService;
import rsc.Services.ConfigServices.ModuloService;
import rsc.Services.ConfigServices.PermisosService;
import rsc.Services.ConfigServices.RolService;
import rsc.Services.ConfigServices.StockService;
import rsc.Services.ConfigServices.UserService;
import rsc.Services.ConfigServices.VistaService;

public final class ConfigFactory {

    public static final RolService ROL_SERVICE(Session session) {
        return (RolService) new RolesRepository().setSession(session);
    }

    public static final UserService USER_SERVICE(Session session) {
        return (UserService) new UserRepository().setSession(session);
    }

    public static final PermisosService PERMISOS_SERVICE(Session session) {
        return (PermisosService) new PermisosRepository().setSession(session);
    }

    public static final VistaService VISTA_SERVICE(Session session) {
        return (VistaService) new VistaRepository().setSession(session);
    }

    public static final DeviceService DEVICE_SERVICE(Session session) {
        return (DeviceService) new DeviceRepository().setSession(session);
    }

    public static final ModuloService MODULO_SERVICE(Session session) {
        return (ModuloService) new ModuloRepository().setSession(session);
    }

    public static final StockService STOCK_SERVICE(Session session) {
        return (StockService) new StockRepository().setSession(session);
    }

    public static final ActionsVistaService ACTIONVISTA_SERVICE(Session session) {
        return (ActionsVistaService) new ActionsRepository().setSession(session);
    }
}
