package com.exchange.rate.calculator.domain.entity;

import com.exchange.rate.calculator.domain.util.PasswordEncoder;
import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;

@Entity
@Getter
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "last_login_datetime")
    private ZonedDateTime lastLoginDateTime;



    public boolean verifyPassword(PasswordEncoder passwordEncoder, String rawPassword) {
        return passwordEncoder.decode(this.password, rawPassword);
    }

    public User login(PasswordEncoder passwordEncoder, String rawPassword) {
        if(!verifyPassword(passwordEncoder, rawPassword)) {
            throw new IllegalStateException();
        }
        this.lastLoginDateTime = ZonedDateTime.now();
        return this;
    }

}
