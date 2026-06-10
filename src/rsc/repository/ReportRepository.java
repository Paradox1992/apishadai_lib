package rsc.repository;

import com.shapi.model.auth.Session;
import rsc.factory.ReportFactory;
import rsc.service.ReportService;
import rsc.service.report.TicketReportService;

public class ReportRepository implements ReportService {

    @Override
    public TicketReportService ticketReporteService(Session session) {
        return ReportFactory.REPORT_TICKET_FACTORY(session);
    }

}
