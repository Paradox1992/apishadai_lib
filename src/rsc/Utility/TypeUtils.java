package rsc.Utility;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.lang.reflect.Type;
import java.util.List;

public final class TypeUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> Type listOf(Class<T> clazz) {
        return new java.lang.reflect.ParameterizedType() {
            @Override
            public Type[] getActualTypeArguments() {
                return new Type[]{clazz};
            }
            @Override
            public Type getRawType() {
                return List.class;
            }
            @Override
            public Type getOwnerType() {
                return null;
            }
        };
    }

    public static <T> JavaType rspPgList(Class<T> clazz) {
        JavaType listType = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
        return mapper.getTypeFactory().constructParametricType(rsc.Data.RspPg.class, listType);
    }
}
