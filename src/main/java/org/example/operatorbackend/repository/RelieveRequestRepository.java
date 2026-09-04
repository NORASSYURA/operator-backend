package org.example.operatorbackend.repository;

import org.example.operatorbackend.model.RelieveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RelieveRequestRepository extends JpaRepository<RelieveRequest, Long> {
    List<RelieveRequest> findByCompanyId(Long companyId);
}
