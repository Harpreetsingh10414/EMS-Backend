package com.ems.Employee.Service.service;

import com.ems.Employee.Service.dto.EmployeeDto;
import com.ems.Employee.Service.model.Employee;
import com.ems.Employee.Service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements iEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto getEmployeeByEmail(String email) {
        Employee emp = employeeRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Employee not found"));

        EmployeeDto dto = new EmployeeDto();
        dto.setEmail(emp.getEmail());
        dto.setRegistered(emp.isRegistered());
        return dto;
    }

    @Override
    public void addEmployee(Employee emp) {
        employeeRepository.save(emp);
    }

    @Override
    public void markEmployeeAsRegistered(String email) {

        Employee employee= employeeRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Employee Not Found"));
        employee.setRegistered(true);
        employeeRepository.save(employee);
    }
}
