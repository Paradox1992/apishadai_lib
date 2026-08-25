package rsc.core.template.service;

import com.shapi.model.util.FilterModel;
import com.shapi.model.auth.Session;
import com.requestsupport.responses.ApiResponse;
import java.util.List;



public interface GenericService<T, ID> {

    GenericService<T, ID> setSession(Session session);

    ApiResponse<Boolean> create(T entity);

    ApiResponse<Boolean> update(T entity);

    ApiResponse<Boolean> update(int id, T entity);

    ApiResponse<Boolean> delete(ID id);

    ApiResponse<T> find(ID id);

    ApiResponse<List<T>> findAll();

    ApiResponse<List<T>> findAllPaged(int page);

    ApiResponse<List<T>> filter(FilterModel filter, int page);

}
