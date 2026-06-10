package rsc.service.config;

import com.shapi.model.Role;
import com.shapi.model.User;
import com.shapi.model.UserStatus;
import com.shapi.model.util.FilterModel;
import java.util.List;
import rsc.data.Response;
import rsc.core.template.service.GenericService;

public interface UserService extends GenericService<User, String> {

    Response<List<User>> filter(FilterModel filter);

    Response<List<Role>> rolesList();

    Response<List<UserStatus>> estadosList();

}
