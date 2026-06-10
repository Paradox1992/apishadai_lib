package rsc.repository.config;

import com.shapi.model.ViewStatus;
import rsc.core.template.repository.GenericRepository;
import rsc.service.config.ViewStatusService;

public final class ViewStatusRepository extends GenericRepository<ViewStatus, Object> implements ViewStatusService {

    public ViewStatusRepository() {
        super(ViewStatus.class);
    }

}
