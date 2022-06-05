package com.exchange.rate.calculator.infrastructure.repository;

import com.exchange.rate.calculator.domain.entity.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserJPARepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
