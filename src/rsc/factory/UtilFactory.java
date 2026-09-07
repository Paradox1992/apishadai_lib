package rsc.factory;

import com.shapi.model.auth.Session;
import rsc.repository.util.BibleRepository;
import rsc.service.util.BibleService;

public final class UtilFactory {

    private UtilFactory() {
    }

    public static final BibleService BIBLE_SERVICE(Session session) {
        return (BibleService) new BibleRepository(session);
    }
}
