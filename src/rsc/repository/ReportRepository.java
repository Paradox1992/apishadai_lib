package rsc.repository;

import com.shapi.model.auth.Session;
import rsc.factory.ReportFactory;
import rsc.service.ReportService;
import rsc.service.report.TicketReportService;
import rsc.service.report.WorkLunchReportService;

public class ReportRepository implements ReportService {

    @Override
    public TicketReportService ticketReporteService(Session session) {
        return ReportFactory.REPORT_TICKET_FACTORY(session);
    }

    @Override
    public WorkLunchReportService lunchReportService(Session session) {
        return ReportFactory.LUNCH_REPORT_SERVICE(session);
    }

}
