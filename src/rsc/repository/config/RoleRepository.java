package rsc.repository.config;

import com.shapi.model.Role;
import rsc.core.template.repository.GenericRepository;
import rsc.service.config.RoleService;

public final class RoleRepository
        extends GenericRepository<Role, String>
        implements RoleService {

    public RoleRepository() {
        super(Role.class);
    }

}
