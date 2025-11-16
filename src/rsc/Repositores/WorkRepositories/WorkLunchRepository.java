package rsc.Repositores.WorkRepositories;

import com.shapi.Models.Marker;
import com.shapi.Models.Utils.FilterModel;
import com.shapi.Models.WorkLunch;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.WorkServices.WorklunchService;
import rsc.Utility.TypeUtils;

public final class WorkLunchRepository extends GenericRepository<WorkLunch, Object> implements WorklunchService {

    public WorkLunchRepository() {
        super(WorkLunch.class);
    }

    @Override
    public Response<Boolean> work(Marker marker) {
        return send(marker, TypeUtils.of(Boolean.class));
    }

    @Override
    public Response<Boolean> lunch(Marker marker) {
        return send(marker, TypeUtils.of(Boolean.class));
    }

    @Override
    public Response<WorkLunch> find(String id) {
        return sendWithParam(id, TypeUtils.of(WorkLunch.class));
    }

    @Override
    public Response<List<WorkLunch>> findUserDate(FilterModel filterModel) {
        return send(filterModel, TypeUtils.of(WorkLunch.class));
    }

}
