package rsc.Repositores.ConfigRepositories;

import com.shapi.Models.Device;
import com.shapi.Models.DeviceEstado;
import com.shapi.Models.Stock;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.ConfigServices.DeviceService;
import rsc.Utility.TypeUtils;

public final class DeviceRepository extends GenericRepository<Device, Object> implements DeviceService {

    public DeviceRepository() {
        super(Device.class);
    }

    @Override
    public Response<List<DeviceEstado>> estadosList() {
        return send(null, TypeUtils.listOf(DeviceEstado.class));
    }

    @Override
    public Response<List<Stock>> stocksList() {
        return send(null, TypeUtils.listOf(Stock.class));
    }
}
