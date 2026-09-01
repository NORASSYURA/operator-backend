package org.example.operatorbackend.repository;

import org.example.operatorbackend.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    // === FOR COMPANY (WORKERS SEE ALL) ===
    // Get all schedules for a company
    List<Schedule> findByCompanyId(Long companyId);

    // Get schedules for a company between dates (for today's schedule)
    List<Schedule> findByCompanyIdAndShiftStartBetween(Long companyId, LocalDateTime start, LocalDateTime end);

    // Get schedules for a company after a date (upcoming)
    List<Schedule> findByCompanyIdAndShiftStartAfter(Long companyId, LocalDateTime date);

    // Get schedules for a company by status
    List<Schedule> findByCompanyIdAndStatus(Long companyId, String status);

    // === FOR OPERATOR (Individual) ===
    // Get schedules for a specific operator
    List<Schedule> findByOperatorId(Long operatorId);

    // Get schedules for operator with status
    List<Schedule> findByOperatorIdAndStatus(Long operatorId, String status);

    // Get schedules for operator between dates
    List<Schedule> findByOperatorIdAndShiftStartBetween(Long operatorId, LocalDateTime start, LocalDateTime end);
}