package rsc.repository;

import rsc.service.sorteos.TicketService;
import rsc.service.sorteos.PromotionCatalogService;
import com.shapi.model.auth.Session;
import rsc.factory.RaffleFactory;
import rsc.service.RaffleService;

public final class RaffleRepository implements RaffleService {

    @Override
    public PromotionCatalogService promocionesService(Session session) {
        return RaffleFactory.PROMO_SERVICE(session);
    }

    @Override
    public TicketService ticketsService(Session session) {
        return RaffleFactory.TICKET_SERVICE(session);
    }

}
