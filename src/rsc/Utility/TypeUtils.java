package rsc.Utility;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import rsc.Core.ApiRequest;
import rsc.Data.PagedResult;
import rsc.Data.Response;
import java.util.List;

public final class TypeUtils {

    private static final ObjectMapper MAPPER = ApiRequest.getMapper();

    public static <T> JavaType of(Class<T> clazz) {
        return MAPPER.getTypeFactory().constructType(clazz);
    }

    public static <T> JavaType listOf(Class<T> clazz) {
        return MAPPER.getTypeFactory()
                .constructCollectionType(List.class, clazz);
    }

    public static <T> JavaType pagedOf(Class<T> clazz) {
        return MAPPER.getTypeFactory()
                .constructParametricType(PagedResult.class, clazz);
    }

    public static JavaType responseOf(JavaType innerType) {
        return MAPPER.getTypeFactory()
                .constructParametricType(Response.class, innerType);
    }
}
