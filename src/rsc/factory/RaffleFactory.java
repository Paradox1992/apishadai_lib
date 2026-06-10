package rsc.factory;

import com.shapi.model.auth.Session;
import rsc.repository.promotion.PromotionRepository;
import rsc.repository.promotion.TicketRepository;
import rsc.service.promotion.PromotionCatalogService;
import rsc.service.promotion.TicketService;

public final class RaffleFactory {

    public static final PromotionCatalogService PROMO_SERVICE(Session session) {
        return (PromotionCatalogService) new PromotionRepository().setSession(session);
    }

    public static final TicketService TICKET_SERVICE(Session session) {
        return (TicketService) new TicketRepository().setSession(session);
    }
}
