package com.ems.Employee.Service.dto;

import lombok.Data;

@Data
public class EmployeeDetailsDto {
    private Long id;
    private String empId;
    private String empName;
    private String email;
    private String phone;
    private String aadhaar;
    private String passport;
    private String dl;
    private String voter;
    private String pan;
    private String designation;
    private Double salary;
    private String gender;
    private String status;
    private String profilePicPath;
    private String aadhaarPicPath;
    private String passportPicPath;
    private String dlPicPath;
    private String voterPicPath;
    private String panPicPath;
    private boolean registered;
}
