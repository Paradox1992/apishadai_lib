package rsc.service.util;

import com.shapi.model.auth.Session;
import java.util.List;
import com.requestsupport.responses.ApiResponse;

public interface PaginationService<T> {

    PaginationService<T> setSession(Session session);

    ApiResponse<List<T>> Paginate();
}
