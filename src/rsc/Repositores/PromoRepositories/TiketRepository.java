package rsc.Repositores.PromoRepositories;

import com.shapi.Models.Tikets;
import com.shapi.Models.Utils.Base64File;
import com.shapi.Models.Utils.FilterModel;
import java.util.List;
import rsc.Core.Templates.Repository.GenericRepository;
import rsc.Data.Response;
import rsc.Services.PromoServices.TicketsService;

public final class TiketRepository extends GenericRepository<Tikets, Object> implements TicketsService {

    public TiketRepository() {
        super(Tikets.class);
    }

    @Override
    public Response<List<Tikets>> filter(FilterModel filter) {
        return send(filter, Tikets.class);
    }

    @Override
    public Response<Base64File> generateTicket(Tikets tiket) {
        return send(tiket, Base64File.class);
    }

}
