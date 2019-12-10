package io.zipcoder.Services;

import io.zipcoder.Repositories.DepartmentRepository;
import io.zipcoder.models.Department;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    private DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;
    }

    public Iterable<Department> findall() {
        return repository.findAll();
    }

}
