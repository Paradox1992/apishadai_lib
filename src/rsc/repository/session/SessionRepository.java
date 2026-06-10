package rsc.repository.session;

import com.shapi.model.auth.Credentials;
import com.shapi.model.auth.Session;
import rsc.core.template.repository.GenericRepository;
import rsc.data.Response;
import rsc.service.auth.SessionService;

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
    public Response<Boolean> logout() {
        return send(null, Boolean.class);
    }

}
