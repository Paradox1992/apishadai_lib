package rsc.Services.ConfigServices;

import com.shapi.Models.Vista;
import com.shapi.Models.VistaEstado;
import java.util.List;
import rsc.Core.Templates.Service.GenericService;
import rsc.Data.Response;

public interface VistaService extends GenericService<Vista, String> {

    Response<List<Vista>> findbyModulo(String mid);

    Response<List<VistaEstado>> estadosList();
    
    
}
