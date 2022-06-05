package com.exchange.rate.calculator.domain.usecase.result;

import com.exchange.rate.calculator.domain.entity.User;
import java.time.ZonedDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class LoginResult implements Result{
    private ZonedDateTime lastLoginAt;

    public static LoginResult from(User user) {
        return LoginResult.builder().lastLoginAt(user.getLastLoginDateTime()).build();
    }
}
