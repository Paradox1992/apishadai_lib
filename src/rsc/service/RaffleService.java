package rsc.service;

import rsc.service.sorteos.TicketService;
import rsc.service.sorteos.PromotionCatalogService;
import com.shapi.model.auth.Session;

public interface RaffleService {

    PromotionCatalogService promocionesService(Session session);

    TicketService ticketsService(Session session);

    
    
}
