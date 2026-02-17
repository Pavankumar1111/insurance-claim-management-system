package com.insurance.claim.controller;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import com.insurance.claim.entity.Claim;
import com.insurance.claim.service.ClaimService;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    private final ClaimService service;

    public ClaimController(ClaimService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public Claim create(@RequestBody Claim claim) {
        return service.create(claim);
    }

    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    @GetMapping
    public List<Claim> getAll() {
        return service.getAll();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}/{status}")
    public Claim updateStatus(@PathVariable Long id,
                              @PathVariable String status) {
        return service.updateStatus(id, status);
    }
}
