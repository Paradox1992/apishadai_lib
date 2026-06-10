package rsc.repository.work;


import com.shapi.model.util.FilterModel;
import com.shapi.model.WorkShift;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import rsc.data.Response;
import rsc.service.work.WorkShiftService;

public final class WorkShiftRepository extends GenericRepository<WorkShift, Object> implements WorkShiftService {

    public WorkShiftRepository() {
        super(WorkShift.class);
    }

    @Override
    public Response<Boolean> work() {
        return send(null, Boolean.class);
    }

    @Override
    public Response<Boolean> lunch() {
        return send(null, Boolean.class);
    }

    @Override
    public Response<WorkShift> find(String id) {
        return sendWithParam(id, WorkShift.class);
    }

    @Override
    public Response<List<WorkShift>> findUserDate(FilterModel filterModel) {
        return send(filterModel, WorkShift.class);
    }

}
