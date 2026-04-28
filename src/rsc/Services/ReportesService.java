package rsc.Services;

import com.shapi.Models.auth.Session;
import rsc.Services.ReportesServices.TicketReporteService;

public interface ReportesService {

    TicketReporteService ticketReporteService(Session session);
}
