package rsc.Repositores.PromoRepositories;

import com.shapi.Models.PromoEstado;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Services.SorteosServices.PromoEstadosService;


public final class PromoEstadosRepository extends GenericRepository<PromoEstado, Object> implements PromoEstadosService {

    public PromoEstadosRepository() {
        super(PromoEstado.class);
    }
}
