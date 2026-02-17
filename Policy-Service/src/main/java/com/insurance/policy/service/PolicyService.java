package com.insurance.policy.service;

import java.util.List;
import com.insurance.policy.entity.Policy;

public interface PolicyService {
    Policy save(Policy policy);
    List<Policy> getAll();
}
