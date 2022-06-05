package com.exchange.rate.calculator.domain.usecase.command;

import com.exchange.rate.calculator.domain.usecase.UseCase;
import com.exchange.rate.calculator.domain.usecase.input.LoginInput;
import com.exchange.rate.calculator.domain.usecase.result.LoginResult;

public interface LoginHandler extends UseCase<LoginInput, LoginResult> {
}
