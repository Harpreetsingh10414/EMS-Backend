package com.ems.Employee.Service.service;

import com.ems.Employee.Service.dto.AddEmployeeRequest;
import com.ems.Employee.Service.dto.EmployeeDto;
import com.ems.Employee.Service.model.Employee;
import com.ems.Employee.Service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements iEmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto getEmployeeByEmail(String email) {
        Employee emp = employeeRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Employee not found"));

        System.out.println("data on get : "+emp);
        EmployeeDto dto = new EmployeeDto();
        dto.setEmail(emp.getEmail());
        dto.setRegistered(emp.isRegistered());
        return dto;
    }

    @Override
    public void addEmployee(AddEmployeeRequest request) {

        Employee employee = new Employee();

        employee.setEmpName(request.getEmpName());
        employee.setEmail(request.getEmail());
        employee.setPhone(request.getPhone());
        employee.setAadhaar(request.getAadhaar());
        employee.setPassport(request.getPassport());
        employee.setDl(request.getDl());
        employee.setVoter(request.getVoter());
        employee.setPan(request.getPan());
        employee.setDesignation(request.getDesignation());
        employee.setSalary(request.getSalary());
        employee.setGender(request.getGender());
        employee.setStatus(request.getStatus());
        employee.setRegistered(false); // default at creation

        // Save files and set their path (optional)
        String uploadDir = "uploads/";

        try {
            if (request.getProfilePic() != null && !request.getProfilePic().isEmpty()) {
                String profilePicName = saveFile(request.getProfilePic(), uploadDir);
                employee.setProfilePicPath(profilePicName);
            }

            if (request.getAadhaarPic() != null && !request.getAadhaarPic().isEmpty()) {
                String aadhaarPicName = saveFile(request.getAadhaarPic(), uploadDir);
                employee.setAadhaarPicPath(aadhaarPicName);
            }

            if (request.getPassportPic() != null && !request.getPassportPic().isEmpty()) {
                String passportPicName = saveFile(request.getPassportPic(), uploadDir);
                employee.setPassportPicPath(passportPicName);
            }

            if (request.getDlPic() != null && !request.getDlPic().isEmpty()) {
                String dlPicName = saveFile(request.getDlPic(), uploadDir);
                employee.setDlPicPath(dlPicName);
            }

            if (request.getVoterPic() != null && !request.getVoterPic().isEmpty()) {
                String voterPicName = saveFile(request.getVoterPic(), uploadDir);
                employee.setVoterPicPath(voterPicName);
            }

            if (request.getPanPic() != null && !request.getPanPic().isEmpty()) {
                String panPicName = saveFile(request.getPanPic(), uploadDir);
                employee.setPanPicPath(panPicName);
            }

        } catch (IOException e) {
            throw new RuntimeException("File saving failed", e);
        }

        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployee() {
        return employeeRepository.findAll();
    }


    @Override
    public void markEmployeeAsRegistered(String email) {

        Employee employee= employeeRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Employee Not Found"));
        employee.setRegistered(true);
        employeeRepository.save(employee);
    }



    private String saveFile(MultipartFile file, String uploadDir) throws IOException {
        String uniqueFileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        Path filePath = uploadPath.resolve(uniqueFileName);
        Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

        return uniqueFileName;
    }

}
