package rsc.Repositores.ConfigRepositories;

import com.shapi.Models.DeviceEstado;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Services.ConfigServices.DeviceEstadoService;

public final class DeviceEstadoRepository extends GenericRepository<DeviceEstado, Object> implements DeviceEstadoService {

    public DeviceEstadoRepository() {
        super(DeviceEstado.class);
    }

}
