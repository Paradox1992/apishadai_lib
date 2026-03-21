package rsc.Services.WorkServices;


import com.shapi.Models.Utils.FilterModel;
import com.shapi.Models.WorkLunch;
import java.util.List;
import rsc.Data.Response;

public interface WorklunchService {

    Response<Boolean> work();

    Response<Boolean> lunch();

    Response<WorkLunch> find(String id);

    Response<List<WorkLunch>> findUserDate(FilterModel filterModel);

}
