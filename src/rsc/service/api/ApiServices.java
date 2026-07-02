package rsc.service.api;

import com.shapi.model.auth.Session;
import rsc.service.ApiMetadataService;
import rsc.service.AuthService;
import rsc.service.ConfigurationService;
import rsc.service.FarmaService;
import rsc.service.LocationService;
import rsc.service.WorkService;
import rsc.service.client.CustomerService;
import rsc.service.ReportService;
import rsc.service.RaffleService;

public interface ApiServices {

    AuthService authService();

    CustomerService clienteService(Session session);

    FarmaService farmaService();

    ConfigurationService configService();

    RaffleService sorteosService();

    LocationService ubicacionService();

    WorkService workService();

    ApiMetadataService metadataService();
    
    ReportService reportesService();
    
}
