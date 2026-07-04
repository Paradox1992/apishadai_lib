package rsc.core.template.repository;

import com.shapi.model.util.FilterModel;
import com.shapi.model.auth.Session;
import com.requestsupport.responses.ApiResponse;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import rsc.core.ApiHandler;

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

    public <R> ApiResponse<R> send(ButtonRoute buttonRoute, Object body, Type responseType) {
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

    public <R> ApiResponse<R> send(ButtonRoute buttonRoute, Object body, Class<R> responseType) {
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

    protected <R> ApiResponse<R> send(Object body, Type responseType) {
        var buttonRoute = RouteHelper.buildRoute(requireSession().getAccessibleContext());
        return ApiHandler.getInstance().exec().send(
                buttonRoute.getUrl(),
                buttonRoute.getMethod(),
                session,
                body,
                responseType
        );
    }

    protected <R> ApiResponse<R> sendWithParam(ID param, Type responseType) {
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
    public ApiResponse<Boolean> create(T entity) {
        return send(RouteHelper.buildRoute(requireSession().getAccessibleContext()), entity, Boolean.class);
    }

    @Override
    public ApiResponse<Boolean> update(T entity) {
        return send(RouteHelper.buildRoute(requireSession().getAccessibleContext()), entity, Boolean.class);
    }

    @Override
    public ApiResponse<Boolean> delete(ID id) {
        return send(RouteHelper.buildRoute(requireSession().getAccessibleContext(), id), null, Boolean.class);
    }

    @Override
    public ApiResponse<T> find(ID id) {
        return send(RouteHelper.buildRoute(requireSession().getAccessibleContext(), id), null, entityClass);
    }

    @Override
    public ApiResponse<List<T>> findAll() {
        return send(RouteHelper.buildRoute(requireSession().getAccessibleContext()), null, TypeUtils.listOf(entityClass));
    }

    @Override
    public ApiResponse<List<T>> findAllPaged(int page) {
        return send(RouteHelper.buildRoutePaged(requireSession().getAccessibleContext(), page), null, TypeUtils.listOf(entityClass));

    }

    @Override
    public ApiResponse<List<T>> filter(FilterModel filter, int page) {
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
