package rsc.core.template.service;

import com.shapi.model.util.FilterModel;
import com.shapi.model.auth.Session;
import java.util.List;

import rsc.data.Response;

public interface GenericService<T, ID> {

    GenericService<T, ID> setSession(Session session);

    Response<Boolean> create(T entity);

    Response<Boolean> update(T entity);

    Response<Boolean> delete(ID id);

    Response<T> find(ID id);

    Response<List<T>> findAll();

    Response<List<T>> findAllPaged(int page);

    Response<List<T>> filter(FilterModel filter, int page);

}
