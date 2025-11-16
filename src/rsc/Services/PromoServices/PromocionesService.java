package rsc.Services.PromoServices;

import com.shapi.Models.PromoEstado;
import com.shapi.Models.Promociones;
import com.shapi.Models.Utils.FilterModel;
import java.util.List;
import rsc.Core.Templates.Service.GenericService;
import rsc.Data.Response;

public interface PromocionesService extends GenericService<Promociones, Object> {

    Response<Promociones> getActive();

    Response<List<Promociones>> filer(FilterModel filter);

    Response<List<PromoEstado>> estadosList();

}
