package rsc.service.api;

import com.shapi.model.auth.Session;
import java.lang.reflect.Type;
import rsc.data.Response;

public interface RequestModel {

    <T> Response<T> send(String route, String method, Session session, Object body, Type responseType);
}
