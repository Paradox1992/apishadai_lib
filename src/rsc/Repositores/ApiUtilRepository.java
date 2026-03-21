package rsc.Repositores;

import rsc.Services.ApiUtilsService;
import rsc.Utility.ApiShadaiConfigManager;

public class ApiUtilRepository implements ApiUtilsService {

    @Override
    public String getVersion() {
        return ApiShadaiConfigManager.getAppVersion();
    }

}
