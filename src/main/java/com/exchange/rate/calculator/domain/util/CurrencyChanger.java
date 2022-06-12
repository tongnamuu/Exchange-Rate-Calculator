package com.exchange.rate.calculator.domain.util;

import com.exchange.rate.calculator.domain.usecase.UseCase;
import com.exchange.rate.calculator.domain.usecase.input.CurrencyChangerInput;
import com.exchange.rate.calculator.domain.usecase.result.CurrencyChangerResult;

public interface CurrencyChanger extends UseCase<CurrencyChangerInput, CurrencyChangerResult> {
}
