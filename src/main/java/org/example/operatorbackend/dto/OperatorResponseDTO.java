package org.example.operatorbackend.dto;

import org.example.operatorbackend.model.Operator;
import java.time.LocalDateTime;

public class OperatorResponseDTO {

    private Long id;
    private String name;
    private String email;
    private Long companyId;
    private boolean isLoggedIn;
    private LocalDateTime lastLogin;

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
}