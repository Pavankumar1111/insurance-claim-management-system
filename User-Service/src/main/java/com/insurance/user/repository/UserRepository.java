package com.insurance.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.insurance.user.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
