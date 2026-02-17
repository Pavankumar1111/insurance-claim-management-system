package com.insurance.policy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.policy.entity.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {}
