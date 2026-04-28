package rsc.Services.SorteosServices;

import com.shapi.Models.Clientes;
import com.shapi.Models.Departamentos;
import com.shapi.Models.Municipios;
import com.shapi.Models.Promociones;
import com.shapi.Models.Tikets;
import com.shapi.Models.Utils.Base64File;
import com.shapi.Models.Utils.FilterModel;
import java.util.List;
import rsc.Core.Templates.Service.GenericService;
import rsc.Data.Response;

public interface TicketsService extends GenericService<Tikets, Object> {

    Response<Base64File> generarTicket(Tikets tiket);

    Response<List<Clientes>> clientesList();

    Response<List<Clientes>> clientesFilter(FilterModel filter);

    Response<Boolean> creaCliente(Clientes cliente);

    Response<Boolean> updatePhoneCliente(Clientes cliente);

    Response<Boolean> isActivePhone(int id);

    Response<List<Departamentos>> departamentosList();

    Response<List<Municipios>> municipios(int departamentoId);

    Response<Promociones> activePromo();
}
