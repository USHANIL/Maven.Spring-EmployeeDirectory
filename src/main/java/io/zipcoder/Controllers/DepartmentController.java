package io.zipcoder.Controllers;

import io.zipcoder.Services.DepartmentService;
import io.zipcoder.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    private DepartmentService service;

    @Autowired
    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/test")
    public String testMe(){
        return "it defenietly Works";
    }

    //get department by id
    @GetMapping("/department/{id}")
    public ResponseEntity<Department> getDepartment (@PathVariable Long id) {
        return new ResponseEntity<Department>(service.getDepartment(id), HttpStatus.OK);
    }

    //create new department
    @PostMapping("/department")
    public ResponseEntity<Department> newDepartment (@RequestBody Department department) {
        return new ResponseEntity<Department>(service.createDept(department), HttpStatus.CREATED);
    }

    //update department
    @PutMapping("/departments/{id}")
    public ResponseEntity<Department> updateDepartment (@RequestBody Department department) {
        return new ResponseEntity<Department>(service.updateDept(department), HttpStatus.OK);
    }
/*
    @PutMapping("API/employees/{id}/manager/{managerId)")
    public ResponseEntity<Department> setManager (@PathVariable int id, @PathVariable int managerId){
        Department set = service.setManager(id,managerId);
        if(set != null){
            return new ResponseEntity<Department>(set,HttpStatus.OK);
        }else{
            return new ResponseEntity<Department>(HttpStatus.BAD_REQUEST);
        }
    }

 */

}
