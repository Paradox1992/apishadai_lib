package rsc.Services.UbicacionServices;

import com.shapi.Models.Municipios;
import java.util.List;
import rsc.Core.Templates.Service.GenericService;
import rsc.Data.Response;

public interface MunicipiosService extends GenericService<Municipios, Object> {

    Response<List<Municipios>> bydepartamento(Object departamentoId);
}
