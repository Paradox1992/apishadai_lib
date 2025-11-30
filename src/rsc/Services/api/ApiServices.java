package rsc.Services.api;

import com.shapi.Models.auth.Session;
import rsc.Services.AuthService;
import rsc.Services.ConfigService;
import rsc.Services.PromoService;
import rsc.Services.UbicacionService;
import rsc.Services.WorkService;
import rsc.Services.ClientesServices.ClientesService;


public interface ApiServices {

    AuthService authService();

    ClientesService clienteService(Session session);

    ConfigService configService();

    PromoService promoService();

    UbicacionService ubicacionService();

    WorkService workService();

    
}
