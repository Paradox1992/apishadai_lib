package rsc.Services.PromoServices;

import com.shapi.Models.Tikets;
import com.shapi.Models.Utils.Base64File;
import com.shapi.Models.Utils.FilterModel;
import java.util.List;
import rsc.Core.Templates.Service.GenericService;
import rsc.Data.Response;

public interface TicketsService extends GenericService<Tikets, Object> {

    Response<List<Tikets>> filter(FilterModel filter);

    Response<Base64File> generateTicket(Tikets tiket);
}
