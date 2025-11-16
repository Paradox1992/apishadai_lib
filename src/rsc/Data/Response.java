package rsc.Data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 * Representa la respuesta genérica del backend. Compatible con Jackson y con
 * paginación opcional (meta).
 * @param <T>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public final class Response<T> implements Serializable {

    private static final long serialVersionUID = 4431126716444649118L;

    private final String message;
    private final long code;
    private final T data;
    private final PgInfo meta;

    @JsonCreator
    public Response(
            @JsonProperty("message") String message,
            @JsonProperty("code") long code,
            @JsonProperty("data") T data,
            @JsonProperty("meta") PgInfo meta) {
        this.message = message;
        this.code = code;
        this.data = data;
        this.meta = meta;
    }

    // Constructor rápido sin paginación
    public Response(String message, long code, T data) {
        this(message, code, data, null);
    }

    // Constructor vacío requerido por Jackson
    public Response() {
        this(null, 0, null, null);
    }

    public String getMessage() {
        return message;
    }

    public long getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public PgInfo getMeta() {
        return meta;
    }

}
