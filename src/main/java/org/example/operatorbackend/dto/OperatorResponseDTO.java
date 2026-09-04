package org.example.operatorbackend.dto;

import org.example.operatorbackend.model.Operator;
import java.time.LocalDateTime;

public class OperatorResponseDTO package org.example.operatorbackend.dto;

import org.example.operatorbackend.model.Operator;
import java.time.LocalDateTime;

public class OperatorResponseDTO {

    private Long id;
    private String name;
    private String email;
    private Long companyId;
    private boolean isLoggedIn;
    private LocalDateTime lastLogin;
    private String role;
    private Double rate;
    private String homeAddress;
    private String phoneNumber;
    private String nric;
    private String jobPosition;

    public OperatorResponseDTO() {
    }

    public static OperatorResponseDTO fromEntity(Operator operator) {
        OperatorResponseDTO dto = new OperatorResponseDTO();
        dto.setId(operator.getId());
        dto.setName(operator.getName());
        dto.setEmail(operator.getEmail());
        dto.setCompanyId(operator.getCompanyId());
        dto.setLoggedIn(operator.isLoggedIn());
        dto.setLastLogin(operator.getLastLogin());
        dto.setRole(operator.getRole());
        dto.setRate(operator.getRate());
        dto.setHomeAddress(operator.getHomeAddress());
        dto.setPhoneNumber(operator.getPhoneNumber());
        dto.setNric(operator.getNric());
        dto.setJobPosition(operator.getJobPosition()); // Added the job position!
        return dto;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }

    public boolean isLoggedIn() { return isLoggedIn; }
    public void setLoggedIn(boolean loggedIn) { isLoggedIn = loggedIn; }

    public LocalDateTime getLastLogin() { return lastLogin; }
    public void setLastLogin(LocalDateTime lastLogin) { this.lastLogin = lastLogin; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Double getRate() { return rate; }
    public void setRate(Double rate) { this.rate = rate; }

    public String getHomeAddress() { return homeAddress; }
    public void setHomeAddress(String homeAddress) { this.homeAddress = homeAddress; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getNric() { return nric; }
    public void setNric(String nric) { this.nric = nric; }

    public String getJobPosition() { return jobPosition; }
    public void setJobPosition(String jobPosition) { this.jobPosition = jobPosition; }
}

    private String jobPosition
    private Long id;
    private String name;
    private String email;
    private Long companyId;
    private boolean isLoggedIn;
    private LocalDateTime lastLogin;
    private String role;
    private Double rate;
    private String homeAddress;
    private String phoneNumber;
    private String nric;

    public OperatorResponseDTO() {
    }

    public static OperatorResponseDTO fromEntity(Operator operator) {
        OperatorResponseDTO dto = new OperatorResponseDTO();
        dto.setId(operator.getId());
        dto.setName(operator.getName());
        dto.setJobPosition(operator.getJobPosition());
        dto.setEmail(operator.getEmail());
        dto.setCompanyId(operator.getCompanyId());
        dto.setLoggedIn(operator.isLoggedIn());
        dto.setLastLogin(operator.getLastLogin());
        dto.setRole(operator.getRole());
        dto.setRate(operator.getRate());
        dto.setHomeAddress(operator.getHomeAddress());
        dto.setPhoneNumber(operator.getPhoneNumber());
        dto.setNric(operator.getNric());
        return dto;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }

    public boolean isLoggedIn() { return isLoggedIn; }
    public void setLoggedIn(boolean loggedIn) { isLoggedIn = loggedIn; }

    public LocalDateTime getLastLogin() { return lastLogin; }
    public void setLastLogin(LocalDateTime lastLogin) { this.lastLogin = lastLogin; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Double getRate() { return rate; }
    public void setRate(Double rate) { this.rate = rate; }

    public String getHomeAddress() { return homeAddress; }
    public void setHomeAddress(String homeAddress) { this.homeAddress = homeAddress; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getNric() { return nric; }
    public void setNric(String nric) { this.nric = nric; }

    public String getJobPosition() { return jobPosition; }

    public void setJobPosition(String jobPosition) { this.jobPosition = jobPosition; }
}
