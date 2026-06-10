package rsc.factory;

import com.shapi.model.auth.Session;
import rsc.core.template.repository.GenericRepository;

import rsc.core.template.service.GenericService;

public final class RepositoryFactory {

    private RepositoryFactory() {
    }

    public static <T, ID> GenericService<T, ID> getRepository(Class<T> entityClass, Session session) {
        return new GenericRepository<T, ID>(entityClass).setSession(session);
    }


}
