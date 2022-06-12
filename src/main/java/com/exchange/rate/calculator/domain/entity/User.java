package com.exchange.rate.calculator.domain.entity;

import com.exchange.rate.calculator.domain.util.PasswordEncoder;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_login_datetime")
    private ZonedDateTime lastLoginDateTime;

    @Builder
    private User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

    private static User create(
        String email,
        String encodedPassword,
        String name
    ) {
        return User.builder()
            .email(email)
            .password(encodedPassword)
            .name(name)
            .build();
    }


    public boolean verifyPassword(PasswordEncoder passwordEncoder, String rawPassword) {
        return passwordEncoder.matches(this.password, rawPassword);
    }

    public User login(PasswordEncoder passwordEncoder, String rawPassword) {
        if(!verifyPassword(passwordEncoder, rawPassword)) {
            throw new IllegalStateException();
        }
        this.lastLoginDateTime = ZonedDateTime.now();
        return this;
    }

}
