package rsc.Data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;


public class PagedResult<T> implements Serializable{

    private static final long serialVersionUID = -3997327717849086270L;

    private final T data;
    private final PgInfo meta;

    @JsonCreator
    public PagedResult(
            @JsonProperty("data") T data,
            @JsonProperty("meta") PgInfo meta
    ) {
        this.data = data;
        this.meta = meta;
    }

    /**
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * @return the meta
     */
    public PgInfo getMeta() {
        return meta;
    }
}
