package com.exchange.rate.calculator.domain.util;

public interface PasswordEncoder {
    String encode(String password);
    boolean matches(String password, String rawPassword);
}
