package rsc.Repositores.PromoRepositories;

import com.shapi.Models.PromoEstado;
import com.shapi.Models.Promociones;
import com.shapi.Models.Utils.FilterModel;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.PromoServices.PromocionesService;
import rsc.Utility.TypeUtils;

public final class PromocionesRepository extends GenericRepository<Promociones, Object> implements PromocionesService {

    public PromocionesRepository() {
        super(Promociones.class);
    }

    @Override
    public Response<Promociones> getActive() {
        return send(null, TypeUtils.of(Promociones.class));
    }

    @Override
    public Response<List<Promociones>> filer(FilterModel filter) {
        return send(filter, TypeUtils.of(Promociones.class));
    }

    @Override
    public Response<List<PromoEstado>> estadosList() {
        return send(null, TypeUtils.of(PromoEstado.class));
    }
}
