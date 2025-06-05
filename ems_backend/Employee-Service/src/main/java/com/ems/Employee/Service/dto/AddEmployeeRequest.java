package com.ems.Employee.Service.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class AddEmployeeRequest {
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

    private MultipartFile profilePic;
    private MultipartFile aadhaarPic;
    private MultipartFile passportPic;
    private MultipartFile dlPic;
    private MultipartFile voterPic;
    private MultipartFile panPic;
}
