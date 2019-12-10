package io.zipcoder.Controllers;

import io.zipcoder.Services.EmployeeService;
import io.zipcoder.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService service) {
        this.employeeService = service;
    }

    @GetMapping("/testss")
    public String testMe(){
        return "it Works";
    }

    @GetMapping("/employees")
    public ResponseEntity<Iterable<Employee>> getAllEmployees () {
        return new ResponseEntity<Iterable<Employee>>(employeeService.getAllEmployees(), HttpStatus.OK);
    }
}
