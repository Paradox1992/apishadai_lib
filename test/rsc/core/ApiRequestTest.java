package rsc.core;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class ApiRequestTest {

    @Test
    public void generatesIdempotencyKeyForPostAndPut() {
        String postKey = ApiRequest.resolveIdempotencyKey("POST", null);
        String putKey = ApiRequest.resolveIdempotencyKey("put", " ");

        assertNotNull(postKey);
        assertNotNull(putKey);
        assertNotEquals(postKey, putKey);
    }

    @Test
    public void preservesProvidedIdempotencyKeyForPostAndPut() {
        assertEquals("post-key", ApiRequest.resolveIdempotencyKey("post", " post-key "));
        assertEquals("put-key", ApiRequest.resolveIdempotencyKey("PUT", "put-key"));
    }

    @Test
    public void omitsIdempotencyKeyForOtherMethods() {
        assertNull(ApiRequest.resolveIdempotencyKey("GET", "provided-key"));
        assertNull(ApiRequest.resolveIdempotencyKey("PATCH", null));
        assertNull(ApiRequest.resolveIdempotencyKey("DELETE", null));
        assertNull(ApiRequest.resolveIdempotencyKey(null, null));
    }
}
