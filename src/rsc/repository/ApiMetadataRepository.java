package rsc.repository;

import rsc.service.ApiMetadataService;
import rsc.util.ApiConfigManager;

public class ApiMetadataRepository implements ApiMetadataService {

    @Override
    public String getVersion() {
        return ApiConfigManager.getAppVersion();
    }

}
