package com.exchange.rate.calculator.domain.usecase.input;

import com.exchange.rate.calculator.domain.entity.Currency;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SendCurrencyInput implements Input {
    private final long userId;
    private final long amount;
    private final Currency currency;
}
