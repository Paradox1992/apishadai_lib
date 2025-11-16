package rsc.Services;

import com.shapi.Models.auth.Session;
import rsc.Services.PromoServices.*;

public interface PromoService {

    PromocionesService promocionesService(Session session);

    TicketsService ticketsService(Session session);

    
    
}
