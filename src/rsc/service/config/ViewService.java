package rsc.service.config;

import com.shapi.model.ViewAction;
import com.shapi.model.View;
import com.shapi.model.ViewStatus;
import java.util.List;
import rsc.core.template.service.GenericService;
import rsc.data.Response;

public interface ViewService extends GenericService<View, String> {

    Response<List<ViewAction>> acctionsList(String vid);

    Response<List<ViewStatus>> estadosList();

    Response<Boolean> crearAccion(ViewAction accion);

    Response<Boolean> EliminarAccion(String id);

}
