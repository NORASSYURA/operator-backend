package org.example.operatorbackend.controller;

import org.example.operatorbackend.model.Company;
import org.example.operatorbackend.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/companies")
@CrossOrigin(origins = "*")
public class CompanyController {

    @Autowired
    private CompanyRepository repository;

    @GetMapping
    public List<Company> getAllCompanies() {
        return repository.findAll();
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return repository.save(company);
    }

    @GetMapping("/{id}")
    public Company getCompanyById(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Company not found"));
    }

    @PutMapping("/{id}")
    public Company updateCompany(@PathVariable Long id, @RequestBody Company company) {
        company.setId(id);
        return repository.save(company);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id) {
        repository.deleteById(id);
    }
}