package rsc.factory;

import com.shapi.model.auth.Session;
import rsc.repository.sorteos.PromotionRepository;
import rsc.repository.sorteos.TicketRepository;
import rsc.service.sorteos.PromotionCatalogService;
import rsc.service.sorteos.TicketService;

public final class RaffleFactory {

    public static final PromotionCatalogService PROMO_SERVICE(Session session) {
        return (PromotionCatalogService) new PromotionRepository().setSession(session);
    }

    public static final TicketService TICKET_SERVICE(Session session) {
        return (TicketService) new TicketRepository().setSession(session);
    }
}
