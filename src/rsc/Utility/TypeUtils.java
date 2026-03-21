package rsc.Utility;

import java.lang.reflect.Type;
import java.util.List;

public final class TypeUtils {

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
}
