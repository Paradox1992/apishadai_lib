package rsc.service.config;

import com.shapi.model.ViewAction;
import com.shapi.model.View;
import com.shapi.model.ViewStatus;
import java.util.List;
import rsc.core.template.service.GenericService;
import com.requestsupport.responses.ApiResponse;

public interface ViewService extends GenericService<View, String> {

    ApiResponse<List<ViewAction>> acctionsList(String vid);

    ApiResponse<List<ViewStatus>> estadosList();

    ApiResponse<Boolean> crearAccion(ViewAction accion);

    ApiResponse<Boolean> EliminarAccion(String id);

}
