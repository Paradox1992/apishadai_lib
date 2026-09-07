package rsc.service.report;

import com.requestsupport.responses.ApiResponse;
import com.shapi.model.HorasLab;
import com.shapi.model.User;
import com.shapi.model.WorkShift;
import java.util.List;
import rsc.core.template.service.GenericService;

public interface WorkLunchReportService extends GenericService<WorkShift, Object> {

    ApiResponse<List<User>> listUsers();
    ApiResponse<HorasLab> getTimes(int userId);
    
}
