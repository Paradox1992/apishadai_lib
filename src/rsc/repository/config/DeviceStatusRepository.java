package rsc.repository.config;

import com.shapi.model.DeviceStatus;
import rsc.core.template.repository.GenericRepository;
import rsc.service.config.DeviceStatusService;

public final class DeviceStatusRepository extends GenericRepository<DeviceStatus, Object> implements DeviceStatusService {

    public DeviceStatusRepository() {
        super(DeviceStatus.class);
    }

}
