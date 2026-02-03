package rsc.Services.ConfigServices;

import com.shapi.Models.Actionsvistas;
import com.shapi.Models.Vista;
import com.shapi.Models.VistaEstado;
import java.util.List;
import rsc.Core.Templates.Service.GenericService;
import rsc.Data.Response;

public interface VistaService extends GenericService<Vista, String> {

    Response<List<Actionsvistas>> acctionsList(String vid);

    Response<List<VistaEstado>> estadosList();

    Response<Boolean> crearAccion(Actionsvistas accion);

    Response<Boolean> EliminarAccion(String id);

}
