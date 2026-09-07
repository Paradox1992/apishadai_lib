
package rsc.repository;

import com.shapi.model.auth.Session;
import rsc.factory.UtilFactory;
import rsc.service.UtilService;
import rsc.service.util.BibleService;


public class UtilRepository implements UtilService{

    @Override
    public BibleService bibleService(Session session) {
        return UtilFactory.BIBLE_SERVICE(session);
    }
    
}
