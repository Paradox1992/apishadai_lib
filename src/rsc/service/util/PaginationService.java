package rsc.service.util;

import com.shapi.model.auth.Session;
import java.util.List;
import rsc.data.Response;

public interface PaginationService<T> {

    PaginationService<T> setSession(Session session);

    Response<List<T>> Paginate();
}
