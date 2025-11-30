package rsc.Repositores;

import com.shapi.Models.auth.Session;
import rsc.Factories.ConfigFactory;
import rsc.Services.ConfigService;
import rsc.Services.ConfigServices.*;

public final class ConfigRepository implements ConfigService {
    
    @Override
    public UserService userService(Session session) {
        return ConfigFactory.USER_SERVICE(session);
    }

    @Override
    public DeviceService deviceService(Session session) {
        return ConfigFactory.DEVICE_SERVICE(session);
    }

    @Override
    public ModuloService moduloService(Session session) {
        return ConfigFactory.MODULO_SERVICE(session);
    }

    @Override
    public PermisosService permisosService(Session session) {
        return ConfigFactory.PERMISOS_SERVICE(session);
    }

    @Override
    public StockService stockService(Session session) {
        return ConfigFactory.STOCK_SERVICE(session);
    }

    @Override
    public VistaService vistaService(Session session) {
        return ConfigFactory.VISTA_SERVICE(session);
    }

    @Override
    public ActionsVistaService actionsVistaService(Session session) {
     return ConfigFactory.ACTIONVISTA_SERVICE(session);
    }
}
