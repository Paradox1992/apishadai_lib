package rsc.Services;

import com.shapi.Models.auth.Session;

import rsc.Services.ConfigServices.*;

public interface ConfigService {
    ActionsVistaService actionsVistaService(Session session);
    
    UserService userService(Session session);

    DeviceService deviceService(Session session);
    
    ModuloService moduloService(Session session);

    PermisosService permisosService(Session session);

    StockService stockService(Session session);

    VistaService vistaService(Session session);
    
}
