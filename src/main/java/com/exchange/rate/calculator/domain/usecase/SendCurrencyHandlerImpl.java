package com.exchange.rate.calculator.domain.usecase;

import com.exchange.rate.calculator.domain.entity.Currency;
import com.exchange.rate.calculator.domain.entity.User;
import com.exchange.rate.calculator.domain.repository.UserRepository;
import com.exchange.rate.calculator.domain.usecase.command.SendCurrencyHandler;
import com.exchange.rate.calculator.domain.usecase.input.CurrencyChangerInput;
import com.exchange.rate.calculator.domain.usecase.input.SendCurrencyInput;
import com.exchange.rate.calculator.domain.usecase.result.CurrencyChangerResult;
import com.exchange.rate.calculator.domain.usecase.result.SendCurrencyResult;
import com.exchange.rate.calculator.domain.util.CurrencyChanger;
import java.time.ZonedDateTime;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendCurrencyHandlerImpl implements SendCurrencyHandler {
    private final CurrencyChanger currencyChanger;
    private final UserRepository userRepository;

    @Override
    public SendCurrencyResult execute(SendCurrencyInput input) {
        User user = userRepository.findById(input.getUserId()).orElseThrow(NoSuchElementException::new);
        CurrencyChangerResult currencyChangerResult = currencyChanger.execute(
            CurrencyChangerInput.builder()
                .from(Currency.USD)
                .to(input.getCurrency())
                .amount(input.getAmount())
                .build()
        );
        return SendCurrencyResult.builder()
            .sendAt(ZonedDateTime.now())
            .amount(currencyChangerResult.getAmount())
            .userId(user.getId())
            .username(user.getEmail())
            .build();
    }
}
