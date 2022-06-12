package com.exchange.rate.calculator.infrastructure.util;

import com.exchange.rate.calculator.domain.entity.Currency;
import com.exchange.rate.calculator.domain.usecase.input.CurrencyChangerInput;
import com.exchange.rate.calculator.domain.usecase.result.CurrencyChangerResult;
import com.exchange.rate.calculator.domain.util.CurrencyChanger;
import org.springframework.stereotype.Component;

@Component
public class CurrencyChangerImpl implements CurrencyChanger {
    @Override
    public CurrencyChangerResult execute(CurrencyChangerInput input) {

        return CurrencyChangerResult.builder()
            .currency(Currency.KRW)
            .amount(1)
            .build();
    }
}
