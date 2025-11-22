package rsc.Data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

/**
 * Representa la respuesta genÃ©rica del backend. Compatible con Jackson y con
 * paginaci opcional (meta).
 *
 * @param <T>
 */
public final class ResponsePaginate<T> implements Serializable {

    private static final long serialVersionUID = 6643757336253708429L;

    private final String message;
    private final long code;
    private final T data;
    private final PgInfo meta;

    @JsonCreator
    public ResponsePaginate(
            @JsonProperty("message") String message,
            @JsonProperty("code") long code,
            @JsonProperty("data") T data,
            @JsonProperty("meta") PgInfo meta) {
        this.message = message;
        this.code = code;
        this.data = data;
        this.meta = meta;
    }

    
    public ResponsePaginate(String message, long code, T data) {
        this(message, code, data, null);
    }

    // Constructor vaci­o requerido por Jackson
    public ResponsePaginate() {
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
