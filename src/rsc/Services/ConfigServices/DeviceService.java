package rsc.Services.ConfigServices;

import com.shapi.Models.Device;
import com.shapi.Models.DeviceEstado;
import com.shapi.Models.Stock;
import java.util.List;
import rsc.Core.Templates.Service.GenericService;
import rsc.Data.Response;


public interface DeviceService extends GenericService<Device, Object> {

    Response<List<DeviceEstado>> estadosList();

    Response<List<Stock>> stocksList();

}
