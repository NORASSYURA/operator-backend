package org.example.operatorbackend.controller;

import org.example.operatorbackend.model.RelieveRequest;
import org.example.operatorbackend.repository.RelieveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/relieve")
@CrossOrigin(origins = "*")
public class RelieveRequestController {

    @Autowired
    private RelieveRequestRepository repository;

    // Create a Relieve Request
    @PostMapping("/create")
    public RelieveRequest createRequest(@RequestBody RelieveRequest request) {
        return repository.save(request);
    }

    // Get all Relieve Requests for the company
    @GetMapping("/company/{companyId}")
    public List<RelieveRequest> getCompanyRequests(@PathVariable Long companyId) {
        return repository.findByCompanyId(companyId);
    }
}
