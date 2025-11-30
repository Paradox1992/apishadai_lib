package rsc.Repositores.Util;

import com.shapi.Models.auth.Session;
import java.lang.reflect.Type;
import java.util.List;
import rsc.Core.ApiHandler;
import rsc.Data.Response;
import rsc.Services.Util.PaginationService;
import rsc.Utility.ButtonRoute;
import rsc.Utility.RouteHelper;
import rsc.Utility.TypeUtils;

public class PaginationRepository<T> implements PaginationService<T> {

    private Session session;
    private final Class<T> entityClass;

    public PaginationRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
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

    @Override
    public PaginationService<T> setSession(Session session) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Response<List<T>> Paginate() {
        return send(RouteHelper.buildRoute(session.getAccessibleContext()), null, TypeUtils.listOf(entityClass));

    }

}
