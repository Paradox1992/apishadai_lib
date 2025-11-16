package rsc.Utility;

public record ButtonRoute(String url, String method, boolean requiresAuth) {

    public String getMethod() {
        return method.toUpperCase();
    }

    public String getUrl() {
        return url;
    }

    public boolean isRequiresAuth() {
        return requiresAuth;
    }

}
