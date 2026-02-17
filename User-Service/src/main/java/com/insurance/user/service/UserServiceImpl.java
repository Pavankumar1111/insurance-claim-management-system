package com.insurance.user.service;

import org.springframework.stereotype.Service;
import com.insurance.user.entity.User;
import com.insurance.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repo;

    public UserServiceImpl(UserRepository repo) {
        this.repo = repo;
    }

    public User register(User user) {
        return repo.save(user);
    }

    public User findByEmail(String email) {
        return repo.findByEmail(email);
    }
}
