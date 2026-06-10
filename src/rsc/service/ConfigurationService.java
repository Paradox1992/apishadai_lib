package rsc.service;

import com.shapi.model.auth.Session;

import rsc.service.config.*;

public interface ConfigurationService {

    ViewActionService viewActionService(Session session);

    UserService userService(Session session);

    DeviceService deviceService(Session session);

    AppModuleService moduloService(Session session);

    PermissionService permisosService(Session session);

    StockService stockService(Session session);

    ViewService vistaService(Session session);

}
