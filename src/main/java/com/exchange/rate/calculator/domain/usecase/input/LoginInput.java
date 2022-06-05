package com.exchange.rate.calculator.domain.usecase.input;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginInput implements Input {
    String email;
    String password;
}
