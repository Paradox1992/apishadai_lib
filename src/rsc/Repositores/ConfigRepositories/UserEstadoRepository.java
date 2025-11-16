package rsc.Repositores.ConfigRepositories;

import com.shapi.Models.UserEstado;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Services.ConfigServices.UserEstadoService;

public final class UserEstadoRepository extends GenericRepository<UserEstado, Object> implements UserEstadoService {

    public UserEstadoRepository() {
        super(UserEstado.class);
    }

}
