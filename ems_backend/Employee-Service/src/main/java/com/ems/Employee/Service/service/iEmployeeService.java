package com.ems.Employee.Service.service;

import com.ems.Employee.Service.dto.AddEmployeeRequest;
import com.ems.Employee.Service.dto.EmployeeDetailsDto;
import com.ems.Employee.Service.model.Employee;

import java.util.List;

public interface iEmployeeService {
    EmployeeDetailsDto getEmployeeByEmail(String email);
    void markEmployeeAsRegistered(String email);
    void addEmployee(AddEmployeeRequest request);
    List<Employee> getEmployee();
}
