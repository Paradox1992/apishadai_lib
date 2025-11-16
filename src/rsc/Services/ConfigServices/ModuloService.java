package rsc.Services.ConfigServices;

import com.shapi.Models.Modulo;
import com.shapi.Models.ModuloEstados;
import java.util.List;
import rsc.Core.Templates.Service.GenericService;
import rsc.Data.Response;

public interface ModuloService extends GenericService<Modulo, Object> {

    Response<List<ModuloEstados>> estadosList();
}
