package rsc.Services.Util;

import com.shapi.Models.auth.Session;
import java.util.List;
import rsc.Data.Response;

public interface PaginationService<T> {

    PaginationService<T> setSession(Session session);

    Response<List<T>> Paginate();
}
