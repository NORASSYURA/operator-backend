package org.example.operatorbackend.controller;

import org.example.operatorbackend.model.JobPosting;
import org.example.operatorbackend.repository.JobPostingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@CrossOrigin(origins = "*")
public class JobPostingController {

    @Autowired
    private JobPostingRepository repository;

    // Admin/Manager creates a job
    @PostMapping("/create")
    public JobPosting createJob(@RequestBody JobPosting job) {
        job.setStatus("OPEN");
        return repository.save(job);
    }

    // Get all jobs for a company (Everyone can see this)
    @GetMapping("/company/{companyId}")
    public List<JobPosting> getAllJobs(@PathVariable Long companyId) {
        return repository.findByCompanyId(companyId);
    }

    // Update job status (Admin/Manager)
    @PutMapping("/{id}")
    public JobPosting updateJob(@PathVariable Long id, @RequestBody JobPosting updatedJob) {
        JobPosting job = repository.findById(id).orElseThrow();
        job.setStatus(updatedJob.getStatus());
        return repository.save(job);
    }
}
