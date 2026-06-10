package rsc.service;

import rsc.service.promotion.TicketService;
import rsc.service.promotion.PromotionCatalogService;
import com.shapi.model.auth.Session;

public interface RaffleService {

    PromotionCatalogService promocionesService(Session session);

    TicketService ticketsService(Session session);

    
    
}
