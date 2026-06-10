package rsc.repository.util;

import com.shapi.model.auth.Session;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Objects;
import rsc.core.ApiHandler;
import rsc.data.Response;
import rsc.service.util.PaginationService;
import rsc.util.ButtonRoute;
import rsc.util.RouteHelper;
import rsc.util.TypeUtils;

public class PaginationRepository<T> implements PaginationService<T> {

    private Session session;
    private final Class<T> entityClass;

    public PaginationRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    private <R> Response<R> send(ButtonRoute buttonRoute, Object body, Type responseType) {
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

    @Override
    public PaginationService<T> setSession(Session session) {
        this.session = session;
        return this;
    }

    @Override
    public Response<List<T>> Paginate() {
        if (session == null || session.getAccessibleContext() == null) {
            throw new IllegalStateException("Session y AccessibleContext son requeridos para paginar");
        }
        return send(RouteHelper.buildRoute(session.getAccessibleContext()), null, TypeUtils.listOf(entityClass));

    }

}
