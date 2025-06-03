package com.ems.Employee.Service.controller;

import com.ems.Employee.Service.dto.AddEmployeeRequest;
import com.ems.Employee.Service.dto.EmployeeDetailsDto;
import com.ems.Employee.Service.model.Employee;
import com.ems.Employee.Service.service.iEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/admin")
public class EmployeeController {

    @Autowired
    private iEmployeeService iEmployeeService;

    // http://localhost:8081/admin/getAllEmployees
    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(iEmployeeService.getEmployee());
    }

    // http://localhost:8081/admin/getByEmail/{email}
    @GetMapping("/getByEmail/{email}")
    public ResponseEntity<EmployeeDetailsDto> getByEmail(@PathVariable String email){
        return ResponseEntity.ok(iEmployeeService.getEmployeeByEmail(email));
    }

    // http://localhost:8081/admin/markRegistered/{email}
    @PutMapping("/markRegistered/{email}")
    public ResponseEntity<?> markRegistered(@PathVariable String email){
        iEmployeeService.markEmployeeAsRegistered(email);
        return ResponseEntity.ok().build();
    }


    //http://localhost:8081/admin/add
    @PostMapping(path="/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> add(@ModelAttribute AddEmployeeRequest request){
        System.out.println("Received employee data: " + request);
        iEmployeeService.addEmployee(request);
        return ResponseEntity.ok("Employee added successfully");
    }

}
