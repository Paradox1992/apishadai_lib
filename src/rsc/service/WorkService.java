package rsc.service;

import com.shapi.model.auth.Session;
import rsc.service.work.*;

public interface WorkService {

    WorkShiftService workShiftService(Session session);
}
