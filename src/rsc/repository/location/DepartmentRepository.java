package rsc.repository.location;

import com.shapi.model.Department;
import rsc.core.template.repository.GenericRepository;
import rsc.service.location.DepartmentService;

public final class DepartmentRepository extends GenericRepository<Department, Object> implements DepartmentService {

    public DepartmentRepository() {
        super(Department.class);
    }

}
