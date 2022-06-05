package com.exchange.rate.calculator.domain.usecase;

import com.exchange.rate.calculator.domain.usecase.input.Input;
import com.exchange.rate.calculator.domain.usecase.result.Result;

@FunctionalInterface
public interface UseCase<T extends Input, R extends Result> {
    R execute(T input);
}
