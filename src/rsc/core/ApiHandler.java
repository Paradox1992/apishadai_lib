package rsc.core;

import rsc.service.api.RequestModel;
import rsc.service.api.RequestHandleService;

public final class ApiHandler implements RequestHandleService {

    private final RequestModel requestModel;

    private static class InstanceHolder {

        private static final ApiHandler INSTANCE = new ApiHandler();
    }

    public static ApiHandler getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private ApiHandler() {
        this.requestModel = new ApiRequest<>();
    }

    @Override
    public RequestModel exec() {
        return requestModel;
    }
}
