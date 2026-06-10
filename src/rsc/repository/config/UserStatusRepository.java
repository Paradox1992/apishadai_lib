package rsc.repository.config;

import com.shapi.model.UserStatus;
import rsc.core.template.repository.GenericRepository;
import rsc.service.config.UserStatusService;

public final class UserStatusRepository extends GenericRepository<UserStatus, Object> implements UserStatusService {

    public UserStatusRepository() {
        super(UserStatus.class);
    }

}
