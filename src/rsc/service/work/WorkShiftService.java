package rsc.service.work;


import com.shapi.model.util.FilterModel;
import com.shapi.model.WorkShift;
import java.util.List;
import rsc.data.Response;

public interface WorkShiftService {

    Response<Boolean> work();

    Response<Boolean> lunch();

    Response<WorkShift> find(String id);

    Response<List<WorkShift>> findUserDate(FilterModel filterModel);

}
