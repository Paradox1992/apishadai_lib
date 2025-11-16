package rsc.Services.WorkServices;

import com.shapi.Models.Marker;
import com.shapi.Models.Utils.FilterModel;
import com.shapi.Models.WorkLunch;
import java.util.List;
import rsc.Data.Response;

public interface WorklunchService {

    Response<Boolean> work(Marker marker);

    Response<Boolean> lunch(Marker marker);

    Response<WorkLunch> find(String id);

    Response<List<WorkLunch>> findUserDate(FilterModel filterModel);

}
