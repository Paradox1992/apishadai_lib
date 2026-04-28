package rsc.Services.api;

import com.shapi.Models.auth.Session;
import rsc.Services.ApiUtilsService;
import rsc.Services.AuthService;
import rsc.Services.ConfigService;
import rsc.Services.UbicacionService;
import rsc.Services.WorkService;
import rsc.Services.ClientesServices.ClientesService;
import rsc.Services.ReportesService;
import rsc.Services.SorteosService;

public interface ApiServices {

    AuthService authService();

    ClientesService clienteService(Session session);

    ConfigService configService();

    SorteosService sorteosService();

    UbicacionService ubicacionService();

    WorkService workService();

    ApiUtilsService UtilService();
    
    ReportesService reportesService();
    
}
