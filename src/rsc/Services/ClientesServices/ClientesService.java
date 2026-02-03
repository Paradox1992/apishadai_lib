package rsc.Services.ClientesServices;

import com.shapi.Models.Clientes;
import java.util.List;
import rsc.Core.Templates.Service.GenericService;
import rsc.Data.Response;

public interface ClientesService extends GenericService<Clientes, Object> {
    
    Response<List<Clientes>> lasts();
    
}
