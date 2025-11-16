package rsc.Repositores;

import com.shapi.Models.auth.Session;
import rsc.Factories.AuthFactory;
import rsc.Services.AuthService;
import rsc.Services.AuthServices.SessionService;

public final class AuthRepository implements AuthService {

    @Override
    public SessionService sessionService(Session session) {
        return AuthFactory.SESSION_FACTORY(session);
    }

}
