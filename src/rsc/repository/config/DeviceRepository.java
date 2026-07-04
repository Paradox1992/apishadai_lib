package rsc.repository.config;

import com.shapi.model.Device;
import com.shapi.model.DeviceStatus;
import com.shapi.model.Stock;
import java.util.List;
import rsc.core.template.repository.GenericRepository;
import com.requestsupport.responses.ApiResponse;
import rsc.service.config.DeviceService;
import rsc.util.TypeUtils;

public final class DeviceRepository extends GenericRepository<Device, Object> implements DeviceService {

    public DeviceRepository() {
        super(Device.class);
    }

    @Override
    public ApiResponse<List<DeviceStatus>> estadosList() {
        return send(null, TypeUtils.listOf(DeviceStatus.class));
    }

    @Override
    public ApiResponse<List<Stock>> stocksList() {
        return send(null, TypeUtils.listOf(Stock.class));
    }
}
