package io.zipcoder.Controllers;

import io.zipcoder.Services.EmployeeService;
import io.zipcoder.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //get all employees
    @GetMapping("/employees")
    public ResponseEntity<Iterable<Employee>> getAllEmployees () {
        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    //get employee by id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeService.getEmployee(id), HttpStatus.OK);
    }

    //post employee
    @PostMapping("/employees")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.CREATED);
    }

    //post employee
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
        employee.setEmployeeNumber(id);
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

    /* test data
    {
        "employeeNumber": 1,
        "firstName": "Usha",
        "lastName": "kun",
        "title":"lead",
        "phoneNumber": "9999",
        "email": "ush@test.com",
        "department":1

    }
    {

        "firstName": "anil",
        "lastName": "kun",
        "title":"Lead",
        "phoneNumber": "999788",
        "email": "anil@test.com",
        "manager": {"employeeNumber":1}

    }
     */

}
