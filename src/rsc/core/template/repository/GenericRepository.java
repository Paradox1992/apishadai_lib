package rsc.core.template.repository;

import com.shapi.model.util.FilterModel;
import com.shapi.model.auth.Session;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import rsc.core.ApiHandler;
import rsc.data.Response;
import rsc.util.RouteHelper;
import rsc.util.TypeUtils;
import rsc.core.template.service.GenericService;
import rsc.util.ButtonRoute;

public class GenericRepository<T, ID> implements GenericService<T, ID> {

    private Session session;
    private final Class<T> entityClass;

    public GenericRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public GenericService<T, ID> setSession(Session session) {
        this.session = session;
        return this;
    }

    public <R> Response<R> send(ButtonRoute buttonRoute, Object body, Type responseType) {
        Objects.requireNonNull(buttonRoute, "buttonRoute cannot be null");
        Objects.requireNonNull(responseType, "responseType cannot be null");
        return ApiHandler.getInstance().exec().send(
                buttonRoute.getUrl(),
                buttonRoute.getMethod(),
                session,
                body,
                responseType
        );
    }

    public <R> Response<R> send(ButtonRoute buttonRoute, Object body, Class<R> responseType) {
        Objects.requireNonNull(buttonRoute, "buttonRoute cannot be null");
        Objects.requireNonNull(responseType, "responseType cannot be null");
        return ApiHandler.getInstance().exec().send(
                buttonRoute.getUrl(),
                buttonRoute.getMethod(),
                session,
                body,
                responseType
        );
    }

    protected <R> Response<R> send(Object body, Type responseType) {
        var buttonRoute = RouteHelper.buildRoute(requireSession().getAccessibleContext());
        return ApiHandler.getInstance().exec().send(
                buttonRoute.getUrl(),
                buttonRoute.getMethod(),
                session,
                body,
                responseType
        );
    }

    protected <R> Response<R> sendWithParam(ID param, Type responseType) {
        var buttonRoute = RouteHelper.buildRoute(requireSession().getAccessibleContext(), param);
        return ApiHandler.getInstance().exec().send(
                buttonRoute.getUrl(),
                buttonRoute.getMethod(),
                session,
                null,
                responseType
        );
    }

    @Override
    public Response<Boolean> create(T entity) {
        return send(RouteHelper.buildRoute(requireSession().getAccessibleContext()), entity, Boolean.class);
    }

    @Override
    public Response<Boolean> update(T entity) {
        return send(RouteHelper.buildRoute(requireSession().getAccessibleContext()), entity, Boolean.class);
    }

    @Override
    public Response<Boolean> delete(ID id) {
        return send(RouteHelper.buildRoute(requireSession().getAccessibleContext(), id), null, Boolean.class);
    }

    @Override
    public Response<T> find(ID id) {
        return send(RouteHelper.buildRoute(requireSession().getAccessibleContext(), id), null, entityClass);
    }

    @Override
    public Response<List<T>> findAll() {
        return send(RouteHelper.buildRoute(requireSession().getAccessibleContext()), null, TypeUtils.listOf(entityClass));
    }

    @Override
    public Response<List<T>> findAllPaged(int page) {
        return send(RouteHelper.buildRoutePaged(requireSession().getAccessibleContext(), page), null, TypeUtils.listOf(entityClass));

    }

    @Override
    public Response<List<T>> filter(FilterModel filter, int page) {
        return send(RouteHelper.buildRoutePaged(requireSession().getAccessibleContext(), page), filter, TypeUtils.listOf(entityClass));
    }

    private Session requireSession() {
        if (session == null) {
            throw new IllegalStateException("Session cannot be null");
        }
        if (session.getAccessibleContext() == null) {
            throw new IllegalStateException("Session AccessibleContext cannot be null");
        }
        return session;
    }

}
