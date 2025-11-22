package rsc.Repositores.SessionRepositories;

import com.shapi.Models.auth.Credentials;
import com.shapi.Models.auth.Session;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.AuthServices.SessionService;

public final class SessionRepository extends GenericRepository<Session, Integer> implements SessionService {

    public SessionRepository(Session session) {
        super(Session.class);
        setSession(session);
    }

    @Override
    public Response<Session> login(Credentials credentials) {
        return send(credentials, Session.class);
    }

    @Override
    public Response<Boolean> logouth() {
        return send(null, Boolean.class);
    }

}
