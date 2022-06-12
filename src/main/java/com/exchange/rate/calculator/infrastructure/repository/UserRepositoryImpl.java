package com.exchange.rate.calculator.infrastructure.repository;

import com.exchange.rate.calculator.domain.entity.User;
import com.exchange.rate.calculator.domain.repository.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    UserJPARepository userJPARepository;


    @Override
    public Optional<User> findByEmail(String email) {
        return userJPARepository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(long id) {
        return userJPARepository.findById(id);
    }

    @Override
    public User save(User user) {
        return userJPARepository.save(user);
    }
}
