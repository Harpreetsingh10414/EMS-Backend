package com.ems.Employee.Service.service;

import com.ems.Employee.Service.dto.AddEmployeeRequest;
import com.ems.Employee.Service.dto.EmployeeDto;
import com.ems.Employee.Service.model.Employee;

import java.util.List;

public interface iEmployeeService {
    EmployeeDto getEmployeeByEmail(String email);
    void markEmployeeAsRegistered(String email);
    void addEmployee(AddEmployeeRequest request);
    List<Employee> getEmployee();
}
