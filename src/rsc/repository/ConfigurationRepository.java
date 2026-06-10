package rsc.repository;

import com.shapi.model.auth.Session;
import rsc.factory.ConfigurationFactory;
import rsc.service.ConfigurationService;
import rsc.service.config.*;

public final class ConfigurationRepository implements ConfigurationService {
    
    @Override
    public UserService userService(Session session) {
        return ConfigurationFactory.USER_SERVICE(session);
    }

    @Override
    public DeviceService deviceService(Session session) {
        return ConfigurationFactory.DEVICE_SERVICE(session);
    }

    @Override
    public AppModuleService moduloService(Session session) {
        return ConfigurationFactory.MODULO_SERVICE(session);
    }

    @Override
    public PermissionService permisosService(Session session) {
        return ConfigurationFactory.PERMISOS_SERVICE(session);
    }

    @Override
    public StockService stockService(Session session) {
        return ConfigurationFactory.STOCK_SERVICE(session);
    }

    @Override
    public ViewService vistaService(Session session) {
        return ConfigurationFactory.VISTA_SERVICE(session);
    }

    @Override
    public ViewActionService viewActionService(Session session) {
     return ConfigurationFactory.ACTIONVISTA_SERVICE(session);
    }
}
