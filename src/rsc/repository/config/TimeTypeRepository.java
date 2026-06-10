package rsc.repository.config;

import com.shapi.model.TimeType;
import rsc.core.template.repository.GenericRepository;
import rsc.service.config.TimeTypeService;

public final class TimeTypeRepository extends GenericRepository<TimeType, Object> implements TimeTypeService {

    public TimeTypeRepository() {
        super(TimeType.class);
    }

}
