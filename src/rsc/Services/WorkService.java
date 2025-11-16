package rsc.Services;

import com.shapi.Models.auth.Session;
import rsc.Services.WorkServices.*;

public interface WorkService {

    WorklunchService worklunchService(Session session);
}
