package rsc.Services.ConfigServices;

import com.shapi.Models.Actionsvistas;
import com.shapi.Models.Modulo;
import com.shapi.Models.Permisos;
import com.shapi.Models.TiposTiempo;
import com.shapi.Models.Vista;
import java.util.List;
import rsc.Core.Templates.Service.GenericService;
import rsc.Data.Response;

public interface PermisosService extends GenericService<Permisos, Object> {

    Response<List<Permisos>> listbyUser(Object id);

    Response<List<Modulo>> listModulos();

    Response<List<Vista>> listVistasbyModulo(Object id);

    Response<List<Actionsvistas>> accionsbyVista(Object id);

    Response<List<TiposTiempo>> listTipoTiempo();

}
