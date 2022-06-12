package com.exchange.rate.calculator.domain.usecase.result;

import com.exchange.rate.calculator.domain.entity.Currency;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class CurrencyChangerResult implements Result {
    private final double amount;
    private final Currency currency;
}
