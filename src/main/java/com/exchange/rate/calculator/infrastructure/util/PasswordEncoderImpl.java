package com.exchange.rate.calculator.infrastructure.util;

import com.exchange.rate.calculator.domain.util.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderImpl implements PasswordEncoder {

    @Override
    public String encode(String password) {
        return password;
    }

    @Override
    public boolean decode(String password, String rawPassword) {
        return password.equals(rawPassword);
    }
}
