package rsc.service.work;


import com.shapi.model.util.FilterModel;
import com.shapi.model.WorkShift;
import java.util.List;
import com.requestsupport.responses.ApiResponse;

public interface WorkShiftService {

    ApiResponse<Boolean> work();

    ApiResponse<Boolean> lunch();

    ApiResponse<WorkShift> find(String id);

    ApiResponse<List<WorkShift>> findUserDate(FilterModel filterModel);

}
