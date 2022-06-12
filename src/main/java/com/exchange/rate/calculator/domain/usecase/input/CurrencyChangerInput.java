package com.exchange.rate.calculator.domain.usecase.input;

import com.exchange.rate.calculator.domain.entity.Currency;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class CurrencyChangerInput implements Input {
    private final double amount;
    private final Currency from;
    private final Currency to;
}
