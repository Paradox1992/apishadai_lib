package rsc.Data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.List;

public class PagedResult<T> {

    private List<T> data;
    private PgInfo meta;

    @JsonCreator
    public PagedResult(
            @JsonProperty("data") List<T> data,
            @JsonProperty("meta") PgInfo meta
    ) {
        this.data = data;
        this.meta = meta;
    }

    /**
     * @return the data
     */
    public List<T> getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(List<T> data) {
        this.data = data;
    }

    /**
     * @return the meta
     */
    public PgInfo getMeta() {
        return meta;
    }

    /**
     * @param meta the meta to set
     */
    public void setMeta(PgInfo meta) {
        this.meta = meta;
    }

}
