package com.exchange.rate.calculator.domain.util;

public interface PasswordEncoder {
    String encode(String password);
    boolean decode(String password, String rawPassword);
}
