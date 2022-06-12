package com.exchange.rate.calculator.domain.usecase.command;

import com.exchange.rate.calculator.domain.usecase.UseCase;
import com.exchange.rate.calculator.domain.usecase.input.SendCurrencyInput;
import com.exchange.rate.calculator.domain.usecase.result.SendCurrencyResult;

public interface SendCurrencyHandler extends UseCase<SendCurrencyInput, SendCurrencyResult> {
}
