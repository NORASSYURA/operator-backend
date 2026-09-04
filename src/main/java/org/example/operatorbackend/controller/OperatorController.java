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

        String role = (operator.getRole() != null) ? operator.getRole() : "USER";
        String token = jwtUtil.generateToken(operator.getEmail(), role);

        Map<String, Object> response = new HashMap<>();
        response.put("token", token);
        response.put("user", OperatorResponseDTO.fromEntity(operator));
        return response;
    }

    @PostMapping("/forgot-password")
    public Map<String, String> forgotPassword(@RequestBody LoginRequest request) {
        Operator operator = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("Operator not found with email: " + request.getEmail()));

        String tempPassword = "Temp1234!";
        operator.setPassword(passwordEncoder.encode(tempPassword));
        repository.save(operator);

        Map<String, String> response = new HashMap<>();
        response.put("message", "Password has been reset to: " + tempPassword);
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
        newOperator.setName(request.getName());
        newOperator.setCompanyId(1L);
        newOperator.setLoggedIn(false);
        newOperator.setHomeAddress(request.getHomeAddress());
        newOperator.setPhoneNumber(request.getPhoneNumber());
        String role = (request.getRole() != null) ? request.getRole() : "USER";
        newOperator.setRole(role);
        repository.save(newOperator);

        return OperatorResponseDTO.fromEntity(newOperator);
    }

    @PutMapping("/{id}")
    public OperatorResponseDTO updateOperator(@PathVariable Long id, @RequestBody Operator updatedOperator) {
        Operator operator = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Operator not found with id: " + id));
        
        operator.setName(updatedOperator.getName());
        operator.setEmail(updatedOperator.getEmail());
        operator.setRate(updatedOperator.getRate());
        operator.setHomeAddress(updatedOperator.getHomeAddress());
        operator.setPhoneNumber(updatedOperator.getPhoneNumber());
                operator.setNric(updatedOperator.getNric());
        repository.save(operator);
        
        return OperatorResponseDTO.fromEntity(operator);
    }

    @PutMapping("/change-password/{id}")
    public OperatorResponseDTO changePassword(@PathVariable Long id, @RequestBody LoginRequest request) {
        Operator operator = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Operator not found with id: " + id));

        if (!passwordEncoder.matches(request.getPassword(), operator.getPassword())) {
            throw new IllegalArgumentException("Current password is incorrect");
        }

        operator.setPassword(passwordEncoder.encode(request.getNewPassword()));
        repository.save(operator);

        return OperatorResponseDTO.fromEntity(operator);
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

class LoginRequest {
    private String name;
    private String email;
    private String password;
    private String newPassword;
    private String role;
    private String homeAddress;
    private String phoneNumber;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNewPassword() { return newPassword; }
    public void setNewPassword(String newPassword) { this.newPassword = newPassword; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getHomeAddress() { return homeAddress; }
    public void setHomeAddress(String homeAddress) { this.homeAddress = homeAddress; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
}
