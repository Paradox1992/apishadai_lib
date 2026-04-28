package rsc.Services;

import rsc.Services.SorteosServices.TicketsService;
import rsc.Services.SorteosServices.PromocionesService;
import com.shapi.Models.auth.Session;

public interface SorteosService {

    PromocionesService promocionesService(Session session);

    TicketsService ticketsService(Session session);

    
    
}
