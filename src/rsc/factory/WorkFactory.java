package rsc.factory;

import com.shapi.model.auth.Session;
import rsc.repository.work.HorasLabRepository;
import rsc.repository.work.WorkShiftRepository;
import rsc.service.work.HorasLabService;
import rsc.service.work.WorkShiftService;

public final class WorkFactory {

    public static final WorkShiftService WORK_SERVICE(Session session) {
        return (WorkShiftService) new WorkShiftRepository().setSession(session);
    }

    public static final HorasLabService HORAS_LAB_SERVICE(Session session) {
        return (HorasLabService) new HorasLabRepository().setSession(session);
    }
}
