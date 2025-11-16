package rsc.Repositores;

import com.shapi.Models.auth.Session;
import rsc.Factories.WorkFactory;
import rsc.Services.WorkService;
import rsc.Services.WorkServices.WorklunchService;

public final class WorkRepository implements WorkService {

    @Override
    public WorklunchService worklunchService(Session session) {
        return WorkFactory.WORK_SERVICE(session);
    }

}
