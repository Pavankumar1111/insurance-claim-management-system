package com.insurance.claim.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.claim.entity.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {}
