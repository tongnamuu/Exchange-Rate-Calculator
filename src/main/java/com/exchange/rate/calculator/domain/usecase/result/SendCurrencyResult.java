package com.exchange.rate.calculator.domain.usecase.result;

import java.time.ZonedDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class SendCurrencyResult implements Result {
    private final long userId;
    private final String username;
    private final ZonedDateTime sendAt;
    private final long amount;
}
