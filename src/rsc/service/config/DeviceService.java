package rsc.service.config;

import com.shapi.model.Device;
import com.shapi.model.DeviceStatus;
import com.shapi.model.Stock;
import java.util.List;
import rsc.core.template.service.GenericService;
import rsc.data.Response;


public interface DeviceService extends GenericService<Device, Object> {

    Response<List<DeviceStatus>> estadosList();

    Response<List<Stock>> stocksList();

}
