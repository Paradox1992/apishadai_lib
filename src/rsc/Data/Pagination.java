package rsc.Data;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class Pagination implements Serializable {

    private static final long serialVersionUID = -958062226613861696L;

    protected PgInfo meta;

    public PgInfo getMeta() {
        return meta;
    }

}
