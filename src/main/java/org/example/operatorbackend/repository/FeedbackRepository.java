package org.example.operatorbackend.repository;

import org.example.operatorbackend.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    List<Feedback> findByCompanyId(Long companyId);
    List<Feedback> findByOperatorId(Long operatorId);
}
