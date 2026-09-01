package org.example.operatorbackend.repository;

import org.example.operatorbackend.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    // Find payments by operator
    List<Payment> findByOperatorId(Long operatorId);

    // Find payments by company (ADD THIS)
    List<Payment> findByCompanyId(Long companyId);
}

