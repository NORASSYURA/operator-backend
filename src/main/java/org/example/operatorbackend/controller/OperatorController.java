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
