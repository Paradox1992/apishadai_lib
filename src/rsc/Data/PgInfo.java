package rsc.Data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public final class PgInfo implements Serializable {

    private static final long serialVersionUID = 8052196359608455593L;

    private final int total;
    private final int current_page;
    private final int last_page;
    private final String path;

    @JsonCreator
    public PgInfo(
            @JsonProperty("total") int total,
            @JsonProperty("current_page") int current_page,
            @JsonProperty("last_page") int last_page,
            @JsonProperty("path") String path
    ) {
        this.total = total;
        this.current_page = current_page;
        this.last_page = last_page;
        this.path = path;
    }

    @JsonProperty("total")
    public int getTotal() {
        return total;
    }

    @JsonProperty("current_page")
    public int getCurrentPage() {
        return current_page;
    }

    @JsonProperty("last_page")
    public int getLastPage() {
        return last_page;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }
}
