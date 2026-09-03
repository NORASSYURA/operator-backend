package org.example.operatorbackend.controller;

import org.example.operatorbackend.model.Document;
import org.example.operatorbackend.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
@CrossOrigin(origins = "*")
public class DocumentController {

    @Autowired
    private DocumentRepository repository;

    // Operator uploads a document
    @PostMapping("/upload")
    public Document uploadDocument(@RequestBody Document document) {
        return repository.save(document);
    }

    // Get all documents for an Operator
    @GetMapping("/operator/{operatorId}")
    public List<Document> getDocumentsByOperator(@PathVariable Long operatorId) {
        return repository.findByOperatorId(operatorId);
    }
}
