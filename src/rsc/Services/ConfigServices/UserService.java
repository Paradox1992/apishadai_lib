package rsc.Services.ConfigServices;

import com.shapi.Models.Roles;
import com.shapi.Models.User;
import com.shapi.Models.UserEstado;
import com.shapi.Models.Utils.FilterModel;
import java.util.List;
import rsc.Data.Response;
import rsc.Core.Templates.Service.GenericService;

public interface UserService extends GenericService<User, String> {

    Response<List<User>> filter(FilterModel filter);

    Response<List<Roles>> rolesList();

    Response<List<UserEstado>> estadosList();

}
