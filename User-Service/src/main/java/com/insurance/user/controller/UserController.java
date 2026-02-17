package com.insurance.user.controller;

import org.springframework.web.bind.annotation.*;
import com.insurance.user.entity.User;
import com.insurance.user.service.UserService;
import com.insurance.user.config.JwtUtil;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    private final JwtUtil jwtUtil;

    public UserController(UserService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = service.findByEmail(user.getEmail());

        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            return jwtUtil.generateToken(
                    dbUser.getEmail(),
                    dbUser.getRole()
            );
        }

        throw new RuntimeException("Invalid Credentials");
    }
}
