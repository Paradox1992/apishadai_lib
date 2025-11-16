package rsc.Factories;

import com.shapi.Models.auth.Session;
import rsc.Core.Templates.Repository.GenericRepository;

import rsc.Core.Templates.Service.GenericService;

public final class RepositoryFactory {

    private RepositoryFactory() {
    }

    public static <T, ID> GenericService<T, ID> getRepository(Class<T> entityClass, Session session) {
        return new GenericRepository<T, ID>(entityClass).setSession(session);
    }


}
