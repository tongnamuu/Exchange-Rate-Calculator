package com.exchange.rate.calculator.domain.repository;

import com.exchange.rate.calculator.domain.entity.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    Optional<User> findById(long id);
    User save(User user);
}
