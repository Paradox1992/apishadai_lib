package rsc.Repositores.ConfigRepositories;

import com.shapi.Models.TiposTiempo;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Services.ConfigServices.TiposTiempoService;

public final class TiposTiempoRepository extends GenericRepository<TiposTiempo, Object> implements TiposTiempoService {

    public TiposTiempoRepository() {
        super(TiposTiempo.class);
    }

}
