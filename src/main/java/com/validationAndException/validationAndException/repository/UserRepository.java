package com.validationAndException.validationAndException.repository;

import com.validationAndException.validationAndException.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(int id);
}
