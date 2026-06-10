package rsc.repository;

import com.shapi.model.auth.Session;
import rsc.factory.WorkFactory;
import rsc.service.WorkService;
import rsc.service.work.WorkShiftService;

public final class WorkRepository implements WorkService {

    @Override
    public WorkShiftService workShiftService(Session session) {
        return WorkFactory.WORK_SERVICE(session);
    }

}
