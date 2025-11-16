package rsc.Repositores.UbicacionRepositories;

import com.shapi.Models.Departamentos;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Services.UbicacionServices.DepartamentosService;

public final class DepartamentosRepository extends GenericRepository<Departamentos, Object> implements DepartamentosService {

    public DepartamentosRepository() {
        super(Departamentos.class);
    }

}
