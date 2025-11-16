package rsc.Core.Templates.Service;

import com.shapi.Models.auth.Session;
import java.util.List;
import rsc.Data.PagedResult;

import rsc.Data.Response;

public interface GenericService<T, ID> {

    GenericService<T, ID> setSession(Session session);

    Response<Boolean> create(T entity);

    Response<Boolean> update(T entity);

    Response<Boolean> delete(ID id);

    Response<T> find(ID id);

    Response<List<T>> findAll();

    Response<PagedResult<T>> findAllPaged();
}
