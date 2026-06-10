package rsc.service;

import com.shapi.model.auth.Session;
import rsc.service.report.TicketReportService;

public interface ReportService {

    TicketReportService ticketReporteService(Session session);
}
