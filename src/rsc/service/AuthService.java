package rsc.service;

import com.shapi.model.auth.Session;
import rsc.service.auth.SessionService;

public interface AuthService {

    SessionService sessionService(Session session);
    
}
