package org.example.operatorbackend.controller;

import org.example.operatorbackend.model.OffDayRequest;
import org.example.operatorbackend.repository.OffDayRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/offday")
@CrossOrigin(origins = "*")
public class OffDayController {

    @Autowired
    private OffDayRequestRepository repository;

    // Operator submits a request
    @PostMapping("/request")
    public OffDayRequest createRequest(@RequestBody OffDayRequest request) {
        request.setStatus("PENDING");
        return repository.save(request);
    }

    // Manager sees ALL requests for their company (to check for blinking alerts)
    @GetMapping("/company/{companyId}")
    public List<OffDayRequest> getCompanyRequests(@PathVariable Long companyId) {
        return repository.findByCompanyId(companyId);
    }

    // Manager sees only PENDING requests
    @GetMapping("/company/{companyId}/pending")
    public List<OffDayRequest> getPendingRequests(@PathVariable Long companyId) {
        return repository.findByCompanyIdAndStatus(companyId, "PENDING");
    }

    // Operator sees their OWN requests
    @GetMapping("/operator/{operatorId}")
    public List<OffDayRequest> getMyRequests(@PathVariable Long operatorId) {
        return repository.findByOperatorId(operatorId);
    }

    // Manager approves or rejects
    @PutMapping("/{id}")
    public OffDayRequest updateRequest(@PathVariable Long id, @RequestBody OffDayRequest updatedRequest) {
        OffDayRequest request = repository.findById(id).orElseThrow();
        request.setStatus(updatedRequest.getStatus()); // "APPROVED" or "REJECTED"
        return repository.save(request);
    }
}
