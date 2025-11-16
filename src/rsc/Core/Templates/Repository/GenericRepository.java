package rsc.Core.Templates.Repository;

import com.shapi.Models.auth.Session;
import java.lang.reflect.Type;
import java.util.List;
import rsc.Core.ApiHandler;
import rsc.Data.Response;
import rsc.Utility.RouteHelper;
import rsc.Utility.TypeUtils;
import rsc.Core.Templates.Service.GenericService;
import rsc.Data.PagedResult;
import rsc.Utility.ButtonRoute;

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

    private <R> Response<R> send(ButtonRoute buttonRoute, Object body, Type responseType) {
        return ApiHandler.getInstance().exec().send(
                buttonRoute.getUrl(),
                buttonRoute.getMethod(),
                session,
                body,
                responseType
        );
    }

    private <R> Response<R> send(ButtonRoute buttonRoute, Object body, Class<R> responseType) {
        return ApiHandler.getInstance().exec().send(
                buttonRoute.getUrl(),
                buttonRoute.getMethod(),
                session,
                body,
                responseType
        );
    }

    protected <R> Response<R> send(Object body, Type responseType) {
        var buttonRoute = RouteHelper.buildRoute(session.getAccessibleContext());
        return ApiHandler.getInstance().exec().send(
                buttonRoute.getUrl(),
                buttonRoute.getMethod(),
                session,
                body,
                responseType
        );

    }

    protected <R> Response<R> sendWithParam(ID param, Type responseType) {
        var buttonRoute = RouteHelper.buildRoute(session.getAccessibleContext(), param);

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
        return send(RouteHelper.buildRoute(session.getAccessibleContext()), entity, Boolean.class);
    }

    @Override
    public Response<Boolean> update(T entity) {
        return send(RouteHelper.buildRoute(session.getAccessibleContext()), entity, Boolean.class);
    }

    @Override
    public Response<Boolean> delete(ID id) {
        return send(RouteHelper.buildRoute(session.getAccessibleContext(), id), null, Boolean.class);
    }

    @Override
    public Response<T> find(ID id) {
        return send(RouteHelper.buildRoute(session.getAccessibleContext(), id), null, entityClass);
    }

    @Override
    public Response<List<T>> findAll() {
        return send(RouteHelper.buildRoute(session.getAccessibleContext()), null, TypeUtils.listOf(entityClass));
    }

    @Override
    public Response<PagedResult<T>> findAllPaged() {
        return send(RouteHelper.buildRoute(session.getAccessibleContext()), null, TypeUtils.of(PagedResult.class));
    }
}
