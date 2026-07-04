package rsc.service.auth;

import com.shapi.model.auth.Credentials;
import com.shapi.model.auth.Session;
import com.requestsupport.responses.ApiResponse;


public interface SessionService {

    ApiResponse<Session> login(Credentials credentials);

    ApiResponse<Boolean> logout();


}
