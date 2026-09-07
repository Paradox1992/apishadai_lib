package rsc.service;

import com.shapi.model.auth.Session;
import rsc.service.util.BibleService;

public interface UtilService {

    BibleService bibleService(Session session);
}
