package org.example.operatorbackend.controller;

import org.example.operatorbackend.model.Payment;
import org.example.operatorbackend.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "*")
public class PaymentController {

    @Autowired
    private PaymentRepository repository;  // ← Variable name is "repository"

    @PostMapping("/log")
    public Payment logPayment(@RequestBody Payment payment) {
        if (payment.getHourlyRate() != null && payment.getHoursWorked() != null) {
            return repository.save(payment);
        }
        return null;
    }

    @GetMapping("/company/{companyId}")
    public List<Payment> getPaymentsByCompany(@PathVariable Long companyId) {
        return repository.findByCompanyId(companyId);  // ← Use "repository" here
    }
}