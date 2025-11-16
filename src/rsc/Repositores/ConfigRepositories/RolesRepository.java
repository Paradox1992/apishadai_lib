package rsc.Repositores.ConfigRepositories;

import com.shapi.Models.Roles;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Services.ConfigServices.RolService;

public final class RolesRepository
        extends GenericRepository<Roles, String>
        implements RolService {

    public RolesRepository() {
        super(Roles.class);
    }

}
