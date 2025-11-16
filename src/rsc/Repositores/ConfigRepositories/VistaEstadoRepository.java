package rsc.Repositores.ConfigRepositories;

import com.shapi.Models.VistaEstado;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Services.ConfigServices.VistaEstadoService;

public final class VistaEstadoRepository extends GenericRepository<VistaEstado, Object> implements VistaEstadoService {

    public VistaEstadoRepository() {
        super(VistaEstado.class);
    }

}
