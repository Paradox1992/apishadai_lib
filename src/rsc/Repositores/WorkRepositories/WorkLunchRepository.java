package rsc.Repositores.WorkRepositories;

import com.shapi.Models.Marker;
import com.shapi.Models.Utils.FilterModel;
import com.shapi.Models.WorkLunch;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.WorkServices.WorklunchService;

public final class WorkLunchRepository extends GenericRepository<WorkLunch, Object> implements WorklunchService {

    public WorkLunchRepository() {
        super(WorkLunch.class);
    }

    @Override
    public Response<Boolean> work(Marker marker) {
        return send(marker, Boolean.class);
    }

    @Override
    public Response<Boolean> lunch(Marker marker) {
        return send(marker, Boolean.class);
    }

    @Override
    public Response<WorkLunch> find(String id) {
        return sendWithParam(id, WorkLunch.class);
    }

    @Override
    public Response<List<WorkLunch>> findUserDate(FilterModel filterModel) {
        return send(filterModel, WorkLunch.class);
    }

}
