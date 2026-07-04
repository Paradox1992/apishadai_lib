package rsc.service.config;

import com.shapi.model.Device;
import com.shapi.model.DeviceStatus;
import com.shapi.model.Stock;
import java.util.List;
import rsc.core.template.service.GenericService;
import com.requestsupport.responses.ApiResponse;


public interface DeviceService extends GenericService<Device, Object> {

    ApiResponse<List<DeviceStatus>> estadosList();

    ApiResponse<List<Stock>> stocksList();

}
