package rsc.Repositores;

import com.shapi.Models.auth.Session;
import rsc.Factories.PromoFactory;
import rsc.Services.PromoService;
import rsc.Services.PromoServices.*;

public final class PromoRepository implements PromoService {

    @Override
    public PromocionesService promocionesService(Session session) {
        return PromoFactory.PROMO_SERVICE(session);
    }

    @Override
    public TicketsService ticketsService(Session session) {
        return PromoFactory.TICKET_SERVICE(session);
    }

}
