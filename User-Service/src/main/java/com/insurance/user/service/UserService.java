package com.insurance.user.service;

import com.insurance.user.entity.User;

public interface UserService {
    User register(User user);
    User findByEmail(String email);
}
