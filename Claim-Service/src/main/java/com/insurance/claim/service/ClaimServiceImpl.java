package com.insurance.claim.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import com.insurance.claim.entity.Claim;
import com.insurance.claim.repository.ClaimRepository;

@Service
public class ClaimServiceImpl implements ClaimService {

    private final ClaimRepository repo;

    public ClaimServiceImpl(ClaimRepository repo) {
        this.repo = repo;
    }

    public Claim create(Claim claim) {
        claim.setStatus("PENDING");
        claim.setCreatedDate(LocalDate.now());
        return repo.save(claim);
    }

    public List<Claim> getAll() {
        return repo.findAll();
    }

    public Claim updateStatus(Long id, String status) {
        Claim claim = repo.findById(id).orElseThrow();
        claim.setStatus(status);
        return repo.save(claim);
    }
}
