package rsc.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Representa la respuesta genérica del backend. Compatible con Jackson y con
 * paginación opcional (meta).
 *
 * @param <T>
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public final class Response<T> extends Pagination   {

    private final String message;
    private final long code;
    private final T data;

    @JsonCreator
    public Response(
            @JsonProperty("message") String message,
            @JsonProperty("code") long code,
            @JsonProperty("data") T data) {
        this.message = message;
        this.code = code;
        this.data = data;
    }

    // Constructor vacío requerido por Jackson
    public Response() {
        this(null, 0, null);
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
}
