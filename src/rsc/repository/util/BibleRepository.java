package rsc.repository.util;

import com.requestsupport.responses.ApiResponse;
import com.shapi.model.auth.Session;
import com.shapi.model.util.Biblia;
import rsc.core.template.repository.GenericRepository;
import rsc.service.util.BibleService;

public final class BibleRepository extends GenericRepository<Biblia, Object> implements BibleService {

    public BibleRepository(Session session) {
        super(Biblia.class);
        setSession(session);
    }

    @Override
    public ApiResponse<Biblia> getRandom() {
        return send(null, Biblia.class);
    }

}
