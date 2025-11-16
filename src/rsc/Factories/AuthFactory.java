package rsc.Factories;

import com.shapi.Models.auth.Session;
import rsc.Repositores.SessionRepositories.SessionRepository;

import rsc.Services.AuthServices.SessionService;

public final class AuthFactory {

    public static final SessionService SESSION_FACTORY(Session session) {
        return (SessionService) new SessionRepository(session);
    }
}
