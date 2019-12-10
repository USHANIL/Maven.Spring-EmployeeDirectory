package io.zipcoder.Services;

import io.zipcoder.Repositories.EmployeeRepository;
import io.zipcoder.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    public EmployeeService(EmployeeRepository repository) {
        this.employeeRepository = repository;
    }

    public Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
