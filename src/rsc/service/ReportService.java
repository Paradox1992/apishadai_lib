package rsc.service;

import com.shapi.model.auth.Session;
import rsc.service.report.TicketReportService;
import rsc.service.report.WorkLunchReportService;

public interface ReportService {

    TicketReportService ticketReporteService(Session session);

    WorkLunchReportService lunchReportService(Session session);
}
