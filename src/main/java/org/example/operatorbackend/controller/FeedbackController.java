package org.example.operatorbackend.controller;

import org.example.operatorbackend.model.Feedback;
import org.example.operatorbackend.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = "*")
public class FeedbackController {

    @Autowired
    private FeedbackRepository repository;

    // Operator submits feedback
    @PostMapping("/submit")
    public Feedback submitFeedback(@RequestBody Feedback feedback) {
        return repository.save(feedback);
    }

    // Admin/Manager sees all feedback
    @GetMapping("/all")
    public List<Feedback> getAllFeedback() {
        return repository.findAll();
    }

    // Operator sees their own feedback
    @GetMapping("/operator/{operatorId}")
    public List<Feedback> getMyFeedback(@PathVariable Long operatorId) {
        return repository.findByOperatorId(operatorId);
    }
}
