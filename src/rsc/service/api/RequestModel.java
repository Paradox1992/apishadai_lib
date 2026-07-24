package rsc.service.api;

import com.shapi.model.auth.Session;
import com.requestsupport.responses.ApiResponse;
import java.lang.reflect.Type;


public interface RequestModel {

    <T> ApiResponse<T> send(String route, String method, Session session, Object body, Type responseType);

    <T> ApiResponse<T> send(String route, String method, Session session, Object body, Type responseType, String idempotencyKey);
}
