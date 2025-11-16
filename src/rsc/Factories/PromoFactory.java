package rsc.Factories;

import com.shapi.Models.auth.Session;
import rsc.Repositores.PromoRepositories.PromocionesRepository;
import rsc.Repositores.PromoRepositories.TiketRepository;
import rsc.Services.PromoServices.PromocionesService;
import rsc.Services.PromoServices.TicketsService;

public final class PromoFactory {

    public static final PromocionesService PROMO_SERVICE(Session session) {
        return (PromocionesService) new PromocionesRepository().setSession(session);
    }

    public static final TicketsService TICKET_SERVICE(Session session) {
        return (TicketsService) new TiketRepository().setSession(session);
    }
}
