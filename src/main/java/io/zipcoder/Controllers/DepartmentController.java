package io.zipcoder.Controllers;

import io.zipcoder.Services.DepartmentService;
import io.zipcoder.models.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/departments")
    public ResponseEntity<Iterable<Department>> findall() {
        return new ResponseEntity<>(service.findall(), HttpStatus.OK);
    }

}
