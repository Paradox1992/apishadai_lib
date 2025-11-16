package rsc.Repositores.ConfigRepositories;

import com.shapi.Models.ModuloEstados;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Services.ConfigServices.ModuloEstadoService;

public final class ModuloEstadoRepository extends GenericRepository<ModuloEstados, Object> implements ModuloEstadoService {

    public ModuloEstadoRepository() {
        super(ModuloEstados.class);
    }

}
