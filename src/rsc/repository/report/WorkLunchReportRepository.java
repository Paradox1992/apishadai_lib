package rsc.repository.report;

import com.requestsupport.responses.ApiResponse;
import com.shapi.model.HorasLab;
import com.shapi.model.User;
import com.shapi.model.WorkShift;
import com.shapi.model.auth.Session;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import rsc.service.report.WorkLunchReportService;
import rsc.util.TypeUtils;

public class WorkLunchReportRepository extends GenericRepository<WorkShift, Object> implements WorkLunchReportService {

    public WorkLunchReportRepository(Session session) {
        super(WorkShift.class);
        setSession(session);
    }

    @Override
    public ApiResponse<List<User>> listUsers() {

        return send(null, TypeUtils.listOf(User.class));
    }

    @Override
    public ApiResponse<HorasLab> getTimes(int userId) {
        return sendWithParam(userId, HorasLab.class);
    }

}
