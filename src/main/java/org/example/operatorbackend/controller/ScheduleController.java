package org.example.operatorbackend.controller;

import org.example.operatorbackend.model.Schedule;
import org.example.operatorbackend.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@CrossOrigin(origins = "*")
public class ScheduleController {

    @Autowired
    private ScheduleRepository repository;

    // === CREATE SCHEDULE (Admin/Company) ===
    @PostMapping
    public Schedule createSchedule(@RequestBody Schedule schedule) {
        return repository.save(schedule);
    }

    // === GET ALL SCHEDULES FOR COMPANY (ALL WORKERS SEE THIS) ===
    @GetMapping("/company/{companyId}")
    public List<Schedule> getSchedulesByCompany(@PathVariable Long companyId) {
        return repository.findByCompanyId(companyId);
    }

    // === GET TODAY'S SCHEDULES FOR COMPANY ===
    @GetMapping("/company/{companyId}/today")
    public List<Schedule> getTodaySchedulesForCompany(@PathVariable Long companyId) {
        LocalDateTime start = LocalDateTime.now().withHour(0).withMinute(0);
        LocalDateTime end = LocalDateTime.now().withHour(23).withMinute(59);
        return repository.findByCompanyIdAndShiftStartBetween(companyId, start, end);
    }

    // === GET UPCOMING SCHEDULES FOR COMPANY ===
    @GetMapping("/company/{companyId}/upcoming")
    public List<Schedule> getUpcomingSchedulesForCompany(@PathVariable Long companyId) {
        return repository.findByCompanyIdAndShiftStartAfter(companyId, LocalDateTime.now());
    }

    // === GET SCHEDULES BY OPERATOR ID (Admin only) ===
    @GetMapping("/operator/{operatorId}")
    public List<Schedule> getSchedulesByOperator(@PathVariable Long operatorId) {
        return repository.findByOperatorId(operatorId);
    }

    // === UPDATE SCHEDULE STATUS ===
    @PutMapping("/{id}/status")
    public Schedule updateScheduleStatus(@PathVariable Long id, @RequestParam String status) {
        Schedule schedule = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        schedule.setStatus(status);
        return repository.save(schedule);
    }

    // === GET SCHEDULE BY ID ===
    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
    }

    // === DELETE SCHEDULE ===
    @DeleteMapping("/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        repository.deleteById(id);
    }
}