package org.example.operatorbackend.controller;

/// Inner class for login request
class LoginRequest {
    private String name; // Add this
    private String email;
    private String password;

    public String getName() { return name; } // Add this getter
    public void setName(String name) { this.name = name; } // Add this setter

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}// <--- This final closing brace was missing!
