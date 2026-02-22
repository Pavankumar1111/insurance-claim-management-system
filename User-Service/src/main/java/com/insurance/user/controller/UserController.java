package com.insurance.user.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import com.insurance.user.entity.User;
import com.insurance.user.service.UserService;
import com.insurance.user.config.JwtUtil;
import com.insurance.user.dto.AuthResponse;
import com.insurance.user.dto.AuthResponse.UserDto;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService service;
    private final JwtUtil jwtUtil;

    public UserController(UserService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody User user) {
        User savedUser = service.register(user);
        String token = jwtUtil.generateToken(savedUser.getEmail(), "USER");
        UserDto userDto = new UserDto(
            savedUser.getId(),
            savedUser.getFirstName(),
            savedUser.getLastName(),
            savedUser.getEmail(),
            savedUser.getPhoneNumber()
        );
        return ResponseEntity.ok(new AuthResponse(token, userDto));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody User user) {
        User dbUser = service.findByEmail(user.getEmail());

        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            String token = jwtUtil.generateToken(dbUser.getEmail(), dbUser.getRole() != null ? dbUser.getRole() : "USER");
            UserDto userDto = new UserDto(
                dbUser.getId(),
                dbUser.getFirstName(),
                dbUser.getLastName(),
                dbUser.getEmail(),
                dbUser.getPhoneNumber()
            );
            return ResponseEntity.ok(new AuthResponse(token, userDto));
        }

        throw new RuntimeException("Invalid Credentials");
    }
}
