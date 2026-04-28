package rsc.Repositores;

import com.shapi.Models.auth.Session;
import rsc.Factories.ReportesFactory;
import rsc.Services.ReportesService;
import rsc.Services.ReportesServices.TicketReporteService;

public class ReporteRepository implements ReportesService {

    @Override
    public TicketReporteService ticketReporteService(Session session) {
        return ReportesFactory.REPORT_TICKET_FACTORY(session);
    }

}
