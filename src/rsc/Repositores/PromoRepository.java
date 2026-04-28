package rsc.Repositores;

import rsc.Services.SorteosServices.TicketsService;
import rsc.Services.SorteosServices.PromocionesService;
import com.shapi.Models.auth.Session;
import rsc.Factories.PromoFactory;
import rsc.Services.SorteosService;

public final class PromoRepository implements SorteosService {

    @Override
    public PromocionesService promocionesService(Session session) {
        return PromoFactory.PROMO_SERVICE(session);
    }

    @Override
    public TicketsService ticketsService(Session session) {
        return PromoFactory.TICKET_SERVICE(session);
    }

}
