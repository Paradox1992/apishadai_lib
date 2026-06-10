package rsc.factory;

import com.shapi.model.auth.Session;
import rsc.repository.report.TicketReportRepository;
import rsc.service.report.TicketReportService;

public final class ReportFactory {

    public static final TicketReportService REPORT_TICKET_FACTORY(Session session) {
        return (TicketReportService) new TicketReportRepository().setSession(session);
    }
}
