package com.exchange.rate.calculator.domain.usecase;

import com.exchange.rate.calculator.domain.entity.User;
import com.exchange.rate.calculator.domain.repository.UserRepository;
import com.exchange.rate.calculator.domain.usecase.command.LoginHandler;
import com.exchange.rate.calculator.domain.usecase.input.LoginInput;
import com.exchange.rate.calculator.domain.usecase.result.LoginResult;
import com.exchange.rate.calculator.domain.util.PasswordEncoder;
import java.util.NoSuchElementException;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class LoginHandlerImpl implements LoginHandler {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public LoginHandlerImpl(UserRepository userRepository,
                            PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public LoginResult execute(LoginInput input) {
        User user = userRepository.findByEmail(input.getEmail()).orElseThrow(NoSuchElementException::new);
        user.login(passwordEncoder, input.getPassword());
        userRepository.save(user);
        return LoginResult.from(user);
    }
}
