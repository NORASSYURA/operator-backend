package com.example.operator.controller; // Make sure this matches your project structure

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/schedule")
@CrossOrigin(origins = "*") // Allows your React Native app to connect safely
public class ScheduleController {

    @GetMapping("/operator/{operatorId}")
    public List<Map<String, String>> getOperatorSchedule(@PathVariable Long operatorId) {
        List<Map<String, String>> shifts = new ArrayList<>();

        // Creating dummy data to test. Later, you can link this to your MySQL repository!
        Map<String, String> shift1 = new HashMap<>();
        shift1.put("shiftDate", "2026-09-02");
        shift1.put("startTime", "08:00 AM");
        shift1.put("endTime", "04:30 PM");
        shift1.put("location", "Main Terminal Facility");
        shift1.put("taskNotes", "Supervise sorting bay and log morning operational weights.");
        shifts.add(shift1);

        Map<String, String> shift2 = new HashMap<>();
        shift2.put("shiftDate", "2026-09-03");
        shift2.put("startTime", "12:00 PM");
        shift2.put("endTime", "08:30 PM");
        shift2.put("location", "North Logistics Yard");
        shift2.put("taskNotes", "Inbound container inspections and driver dispatch sign-offs.");
        shifts.add(shift2);

        return shifts;
    }
}
