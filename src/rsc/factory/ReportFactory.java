package rsc.factory;

import com.shapi.model.auth.Session;
import rsc.repository.report.TicketReportRepository;
import rsc.repository.report.WorkLunchReportRepository;
import rsc.service.report.TicketReportService;
import rsc.service.report.WorkLunchReportService;

public final class ReportFactory {

    public static final TicketReportService REPORT_TICKET_FACTORY(Session session) {
        return (TicketReportService) new TicketReportRepository().setSession(session);
    }

    public static final WorkLunchReportService LUNCH_REPORT_SERVICE(Session session) {
        return (WorkLunchReportService) new WorkLunchReportRepository(session);
    }
}
