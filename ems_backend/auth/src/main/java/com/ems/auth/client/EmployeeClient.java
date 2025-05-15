package com.ems.auth.client;

import com.ems.auth.dto.EmployeeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

    // http://localhost:8080/admin/getByEmail/{email}
    @GetMapping("/admin/getByEmail/{email}")
    EmployeeDto getEmployeeByEmail(@PathVariable String email);

    // http://localhost:8080/admin/markRegistered/{email}
    @PutMapping("/admin/markRegistered/{email}")
    void markEmployeeRegistered(@PathVariable String email);
}
