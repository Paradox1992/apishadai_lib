package rsc.Repositores.ConfigRepositories;

import com.shapi.Models.Roles;
import com.shapi.Models.User;
import com.shapi.Models.UserEstado;
import com.shapi.Models.Utils.FilterModel;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.ConfigServices.UserService;
import rsc.Utility.TypeUtils;

public final class UserRepository extends GenericRepository<User, String>
        implements UserService {

    public UserRepository() {
        super(User.class);
    }

    @Override
    public Response<List<User>> filter(FilterModel filter) {
        return send(filter, TypeUtils.of(User.class));
    }

    @Override
    public Response<List<Roles>> rolesList() {
        return send(null, TypeUtils.of(Roles.class));
    }

    @Override
    public Response<List<UserEstado>> estadosList() {
        return send(null, TypeUtils.of(UserEstado.class));
    }

}
