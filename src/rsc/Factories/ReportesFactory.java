package rsc.Factories;

import com.shapi.Models.auth.Session;
import rsc.Repositores.ReportesRepositories.TicketReporteRepository;
import rsc.Services.ReportesServices.TicketReporteService;

public final class ReportesFactory {

    public static final TicketReporteService REPORT_TICKET_FACTORY(Session session) {
        return (TicketReporteService) new TicketReporteRepository().setSession(session);
    }
}
