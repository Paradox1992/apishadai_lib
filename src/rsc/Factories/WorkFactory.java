package rsc.Factories;

import com.shapi.Models.auth.Session;
import rsc.Repositores.WorkRepositories.WorkLunchRepository;
import rsc.Services.WorkServices.WorklunchService;

public final class WorkFactory {

    public static final WorklunchService WORK_SERVICE(Session session) {
        return (WorklunchService) new WorkLunchRepository().setSession(session);
    }
}
