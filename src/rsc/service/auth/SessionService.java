package rsc.service.auth;

import com.shapi.model.auth.Credentials;
import com.shapi.model.auth.Session;
import rsc.data.Response;

public interface SessionService {

    Response<Session> login(Credentials credentials);

    Response<Boolean> logout();


}
