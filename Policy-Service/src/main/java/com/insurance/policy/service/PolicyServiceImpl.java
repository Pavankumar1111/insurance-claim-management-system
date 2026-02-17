package com.insurance.policy.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.insurance.policy.entity.Policy;
import com.insurance.policy.repository.PolicyRepository;

@Service
public class PolicyServiceImpl implements PolicyService {

    private final PolicyRepository repo;

    public PolicyServiceImpl(PolicyRepository repo) {
        this.repo = repo;
    }

    public Policy save(Policy policy) {
        return repo.save(policy);
    }

    public List<Policy> getAll() {
        return repo.findAll();
    }
}
