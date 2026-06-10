package rsc.factory;

import com.shapi.model.auth.Session;
import rsc.repository.session.SessionRepository;

import rsc.service.auth.SessionService;

public final class AuthFactory {

    public static final SessionService SESSION_FACTORY(Session session) {
        return (SessionService) new SessionRepository(session);
    }
}
