package com.ems.Employee.Service.controller;

import com.ems.Employee.Service.dto.EmployeeDto;
import com.ems.Employee.Service.model.Employee;
import com.ems.Employee.Service.service.iEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class EmployeeController {

    @Autowired
    private iEmployeeService iEmployeeService;

    // http://localhost:8080/admin/getByEmail/{email}
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<EmployeeDto> getByEmail(@PathVariable String email){
        return ResponseEntity.ok(iEmployeeService.getEmployeeByEmail(email));
    }

    // http://localhost:8080/admin/markRegistered/{email}
    @PutMapping("/markRegistered/{email}")
    public ResponseEntity<?> markRegistered(@PathVariable String email){
        iEmployeeService.markEmployeeAsRegistered(email);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Employee employee){
        iEmployeeService.addEmployee(employee);
        return ResponseEntity.ok("Employee added successfully");
    }

}
