package rsc.Services;

import com.shapi.Models.auth.Session;
import rsc.Services.AuthServices.SessionService;

public interface AuthService {

    SessionService sessionService(Session session);
    
}
