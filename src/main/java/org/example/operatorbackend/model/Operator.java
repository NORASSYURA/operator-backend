package org.example.operatorbackend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "operators")
public class Operator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String password;
    private String role;
    private Double rate;
    private String homeAddress;
    private String phoneNumber;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "is_logged_in")
    private Boolean isLoggedIn = false;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "last_logout")
    private LocalDateTime lastLogout;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Double getRate() { return rate; }
    public void setRate(Double rate) { this.rate = rate; }

    public String getHomeAddress() { return homeAddress; }
    public void setHomeAddress(String homeAddress) { this.homeAddress = homeAddress; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public List<Document> getDocuments() { return documents; }
    public void setDocuments(List<Document> documents) { this.documents = documents; }

    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }

    public boolean isLoggedIn() { return isLoggedIn; }
    public void setLoggedIn(boolean loggedIn) { isLoggedIn = loggedIn; }

    public LocalDateTime getLastLogin() { return lastLogin; }
    public void setLastLogin(LocalDateTime lastLogin) { this.lastLogin = lastLogin; }

    public LocalDateTime getLastLogout() { return lastLogout; }
    public void setLastLogout(LocalDateTime lastLogout) { this.lastLogout = lastLogout; }
}
