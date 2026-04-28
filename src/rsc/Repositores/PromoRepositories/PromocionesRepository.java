package rsc.Repositores.PromoRepositories;

import com.shapi.Models.PromoEstado;
import com.shapi.Models.Promociones;
import com.shapi.Models.Utils.FilterModel;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.SorteosServices.PromocionesService;
import rsc.Utility.TypeUtils;

public final class PromocionesRepository extends GenericRepository<Promociones, Object> implements PromocionesService {

    public PromocionesRepository() {
        super(Promociones.class);
    }

    @Override
    public Response<List<Promociones>> filter(FilterModel filter) {
        return send(filter, TypeUtils.listOf(Promociones.class));
    }

    @Override
    public Response<List<PromoEstado>> estadosList() {
        return send(null, TypeUtils.listOf(PromoEstado.class));
    }
}
