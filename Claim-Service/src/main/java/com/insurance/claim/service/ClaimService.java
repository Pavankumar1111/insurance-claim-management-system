package com.insurance.claim.service;

import java.util.List;
import com.insurance.claim.entity.Claim;

public interface ClaimService {
    Claim create(Claim claim);
    List<Claim> getAll();
    Claim updateStatus(Long id, String status);
}
