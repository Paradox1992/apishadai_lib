package rsc.repository;

import com.shapi.model.auth.Session;
import rsc.factory.AuthFactory;
import rsc.service.AuthService;
import rsc.service.auth.SessionService;

public final class AuthRepository implements AuthService {

    @Override
    public SessionService sessionService(Session session) {
        return AuthFactory.SESSION_FACTORY(session);
    }

}
