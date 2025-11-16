package rsc.Services.AuthServices;

import com.shapi.Models.auth.Credentials;
import com.shapi.Models.auth.Session;
import rsc.Data.Response;

public interface SessionService {

    Response<Session> login(Credentials credentials);

    Response<Boolean> logouth();


}
