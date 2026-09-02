package org.example.operatorbackend.controller;

import org.example.operatorbackend.dto.OperatorResponseDTO;
import org.example.operatorbackend.model.Operator;
import org.example.operatorbackend.repository.OperatorRepository;
import org.example.operatorbackend.exception.ResourceNotFoundException;
import org.example.operatorbackend.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/operators")
@CrossOrigin(origins = "*")
public class OperatorController {

    @Autowired
    private OperatorRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest request) {
        Operator operator = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Operator not found with email: " + request.getEmail()));

        if (!passwordEncoder.matches(request.getPassword(), operator.getPassword())) {
            throw new IllegalArgumentException("Invalid email or password");
        }

        operator.setLoggedIn(true);
        operator.setLastLogin(LocalDateTime.now());
        repository.save(operator);

        // Generate the JWT Token
        String token = jwtUtil.generateToken(operator.getEmail(), operator.getRole());

        // Return the Token AND the User Data
        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", OperatorResponseDTO.fromEntity(operator));

        return response;
    }

    @PostMapping("/register")
    public OperatorResponseDTO register(@RequestBody LoginRequest request) {
        if (repository.findByEmail(request.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email already registered");
        }

        Operator newOperator = new Operator();
        newOperator.setEmail(request.getEmail());
        newOperator.setPassword(passwordEncoder.encode(request.getPassword()));

        // ADD THIS LINE to set the name
        newOperator.setName(request.getName());

        newOperator.setCompanyId(1L);
        newOperator.setLoggedIn(false);
        newOperator.setRole("USER");

        repository.save(newOperator);

        return OperatorResponseDTO.fromEntity(newOperator);
    }
    @DeleteMapping("/{id}")
    public void deleteOperator(@PathVariable Long id) {
        repository.deleteById(id);
    }
    @PostMapping("/logout/{id}")
    public OperatorResponseDTO logout(@PathVariable Long id) {
        Operator operator = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Operator not found with id: " + id));

        operator.setLoggedIn(false);
        operator.setLastLogout(LocalDateTime.now());
        repository.save(operator);

        return OperatorResponseDTO.fromEntity(operator);
    }

    // THESE ENDPOINTS NOW REQUIRE A TOKEN IN THE HEADER
    @GetMapping("/company/{companyId}")
    public List<OperatorResponseDTO> getOperatorsByCompany(@PathVariable Long companyId) {
        return repository.findByCompanyId(companyId).stream()
                .map(OperatorResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }

    @GetMapping("/active")
    public List<OperatorResponseDTO> getActiveOperators() {
        return repository.findByIsLoggedInTrue().stream()
                .map(OperatorResponseDTO::fromEntity)
                .collect(Collectors.toList());
    }
}
