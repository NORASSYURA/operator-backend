package org.example.operatorbackend.controller;

import org.example.operatorbackend.model.BookOffRequest;
import org.example.operatorbackend.repository.BookOffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookoff")
@CrossOrigin(origins = "*")
public class BookOffController {

    @Autowired
    private BookOffRepository repository;

    @PostMapping("/request")
    public BookOffRequest createRequest(@RequestBody BookOffRequest request) {
        return repository.save(request);
    }

    @GetMapping("/operator/{operatorId}")
    public List<BookOffRequest> getOperatorRequests(@PathVariable Long operatorId) {
        return repository.findByOperatorId(operatorId);
    }
}

