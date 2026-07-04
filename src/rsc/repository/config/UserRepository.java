package rsc.repository.config;

import com.shapi.model.Role;
import com.shapi.model.User;
import com.shapi.model.UserStatus;
import com.shapi.model.util.FilterModel;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import com.requestsupport.responses.ApiResponse;
import rsc.service.config.UserService;
import rsc.util.TypeUtils;

public final class UserRepository extends GenericRepository<User, String>
        implements UserService {
    
    public UserRepository() {
        super(User.class);
    }
    
    @Override
    public ApiResponse<List<User>> filter(FilterModel filter) {
        return send(filter, User.class);
    }
    
    @Override
    public ApiResponse<List<Role>> rolesList() {
        return send(null, TypeUtils.listOf(Role.class));
    }
    
    @Override
    public ApiResponse<List<UserStatus>> estadosList() {
        return send(null, TypeUtils.listOf(UserStatus.class));
    }
    
}
