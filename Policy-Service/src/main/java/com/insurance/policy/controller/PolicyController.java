package com.insurance.policy.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.insurance.policy.entity.Policy;
import com.insurance.policy.service.PolicyService;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    private final PolicyService service;

    public PolicyController(PolicyService service) {
        this.service = service;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Policy> save(@RequestBody Policy policy) {
        return ResponseEntity.ok(service.save(policy));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    public ResponseEntity<List<Policy>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
