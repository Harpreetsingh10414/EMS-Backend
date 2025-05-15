package com.ems.Employee.Service.service;

import com.ems.Employee.Service.dto.EmployeeDto;
import com.ems.Employee.Service.model.Employee;

public interface iEmployeeService {
    EmployeeDto getEmployeeByEmail(String email);
    void markEmployeeAsRegistered(String email);
    void addEmployee(Employee emp);
}
