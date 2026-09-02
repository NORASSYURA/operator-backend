package org.example.operatorbackend.repository;

import org.example.operatorbackend.model.OffDayRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OffDayRequestRepository extends JpaRepository<OffDayRequest, Long> {
    List<OffDayRequest> findByCompanyId(Long companyId);
    List<OffDayRequest> findByOperatorId(Long operatorId);
    List<OffDayRequest> findByCompanyIdAndStatus(Long companyId, String status);
}
