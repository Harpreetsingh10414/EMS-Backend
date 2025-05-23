package com.ems.Employee.Service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String empId;        // You can auto-generate this if needed
    private String empName;      // Mapped from `fullName`

    @Column(unique = true)
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

    private String profilePicPath;     // Store file path or filename (optional)
    private String aadhaarPicPath;
    private String passportPicPath;
    private String dlPicPath;
    private String voterPicPath;
    private String panPicPath;

    private boolean registered;
}
