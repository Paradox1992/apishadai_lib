package rsc.service.config;

import com.shapi.model.Role;
import com.shapi.model.User;
import com.shapi.model.UserStatus;
import com.shapi.model.util.FilterModel;
import java.util.List;
import com.requestsupport.responses.ApiResponse;
import rsc.core.template.service.GenericService;

public interface UserService extends GenericService<User, String> {

    ApiResponse<List<User>> filter(FilterModel filter);

    ApiResponse<List<Role>> rolesList();

    ApiResponse<List<UserStatus>> estadosList();

}
