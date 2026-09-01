package org.example.operatorbackend.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long operatorId;
    private Long companyId;
    private LocalDate payPeriodEnd;
    private Double hourlyRate;
    private Double hoursWorked;
    private Double totalPayout;
    private String status = "PENDING";

    // --- GETTERS AND SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getOperatorId() { return operatorId; }
    public void setOperatorId(Long operatorId) { this.operatorId = operatorId; }

    public LocalDate getPayPeriodEnd() { return payPeriodEnd; }
    public void setPayPeriodEnd(LocalDate payPeriodEnd) { this.payPeriodEnd = payPeriodEnd; }

    public Double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(Double hourlyRate) { this.hourlyRate = hourlyRate; }

    public Double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(Double hoursWorked) { this.hoursWorked = hoursWorked; }

    public Double getTotalPayout() { return totalPayout; }
    public void setTotalPayout(Double totalPayout) { this.totalPayout = totalPayout; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
