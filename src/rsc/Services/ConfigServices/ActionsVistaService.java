package rsc.Services.ConfigServices;

import com.shapi.Models.Actionsvistas;
import java.util.List;
import rsc.Core.Templates.Service.GenericService;
import rsc.Data.Response;

public interface ActionsVistaService extends GenericService<Actionsvistas, Object> {

    Response<List<Actionsvistas>> findbyVista(String vistaId);
    
}
