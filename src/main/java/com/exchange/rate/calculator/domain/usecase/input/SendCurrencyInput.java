package com.exchange.rate.calculator.domain.usecase.input;

import com.exchange.rate.calculator.domain.entity.Currency;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class SendCurrencyInput implements Input {
    private final long userId;
    private final double amount;
    private final Currency currency;
}
