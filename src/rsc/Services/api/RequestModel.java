package rsc.Services.api;

import com.shapi.Models.auth.Session;
import java.lang.reflect.Type;
import rsc.Data.Response;

public interface RequestModel {

    <T> Response<T> send(String route, String method, Session session, Object body, Type responseType);
}
