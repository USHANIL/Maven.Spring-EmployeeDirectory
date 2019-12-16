package io.zipcoder.Services;

import io.zipcoder.Repositories.DepartmentRepository;
import io.zipcoder.models.Department;
import io.zipcoder.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {


    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    EmployeeService employeeService;



    public Department getDepartment(Long id){
        return departmentRepository.findById(id).get();
    }

    public Iterable<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public Department createDept(Department department){
        return departmentRepository.save(department);
    }

    public Department updateDept(Department department){
        return departmentRepository.save(department);
    }

    public Department setManager(Long id, Long managerId){
        Department department = getDepartment(id);
        Employee manager = employeeService.getEmployee(managerId);
        if(department != null && manager != null){
            department.setManager(manager);
            return departmentRepository.save(department);
        }else {
            return  null;
        }

    }
}
