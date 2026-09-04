package org.example.operatorbackend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "relieve_requests")
public class RelieveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long relieverId;
    private String relieverName;
    private String jobPosition;
    private String date;
    private Long companyId;
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getRelieverId() { return relieverId; }
    public void setRelieverId(Long relieverId) { this.relieverId = relieverId; }

    public String getRelieverName() { return relieverName; }
    public void setRelieverName(String relieverName) { this.relieverName = relieverName; }

    public String getJobPosition() { return jobPosition; }
    public void setJobPosition(String jobPosition) { this.jobPosition = jobPosition; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Long getCompanyId() { return companyId; }
    public void setCompanyId(Long companyId) { this.companyId = companyId; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
