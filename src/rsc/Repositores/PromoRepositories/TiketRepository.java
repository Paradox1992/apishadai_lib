package rsc.Repositores.PromoRepositories;

import com.shapi.Models.Clientes;
import com.shapi.Models.Departamentos;
import com.shapi.Models.Municipios;
import com.shapi.Models.Promociones;
import com.shapi.Models.Tikets;
import com.shapi.Models.Utils.Base64File;
import com.shapi.Models.Utils.FilterModel;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.PromoServices.TicketsService;
import rsc.Utility.TypeUtils;

public final class TiketRepository extends GenericRepository<Tikets, Object> implements TicketsService {

    public TiketRepository() {
        super(Tikets.class);

    }

    @Override
    public Response<Base64File> generarTicket(Tikets tiket) {
        return send(tiket, Base64File.class);
    }

    @Override
    public Response<Boolean> create(Tikets entity) {
        return null;
    }

    @Override
    public Response<List<Clientes>> clientesList() {
        return send(null, TypeUtils.listOf(Clientes.class));
    }

    @Override
    public Response<List<Clientes>> clientesFilter(FilterModel filter) {
        return send(filter, TypeUtils.listOf(Clientes.class));
    }

    @Override
    public Response<Boolean> creaCliente(Clientes cliente) {
        return send(cliente, Boolean.class);
    }

    @Override
    public Response<Boolean> updatePhoneCliente(Clientes cliente) {
        return send(cliente, Boolean.class);

    }

    @Override
    public Response<Boolean> isActivePhone(int id) {
        return sendWithParam(id, Boolean.class);

    }

    @Override
    public Response<List<Departamentos>> departamentosList() {
        return send(null, TypeUtils.listOf(Departamentos.class));
    }

    @Override
    public Response<List<Municipios>> municipios(int departamentoId) {
        return sendWithParam(departamentoId, TypeUtils.listOf(Municipios.class));

    }

    @Override
    public Response<Promociones> activePromo() {
        return send(null, Promociones.class);
    }

}
