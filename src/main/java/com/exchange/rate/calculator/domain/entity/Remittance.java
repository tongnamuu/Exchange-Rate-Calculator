package com.exchange.rate.calculator.domain.entity;

import java.time.ZonedDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Remittance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "currency", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Currency currency;

    @Column(name = "created_at", nullable = false)
    private ZonedDateTime createdAt;

    @Column(name = "completed_at", nullable = true)
    private ZonedDateTime completedAt;

    @Column(name = "status", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private RemittanceStatus status;

    @Builder(access = AccessLevel.PRIVATE)
    private Remittance(Long userId, Double amount, Currency currency) {
        this.userId = userId;
        this.amount = amount;
        this.currency = currency;
        this.status = RemittanceStatus.ACCEPT;
        this.createdAt = ZonedDateTime.now();
    }

    public static Remittance create(long userId, double amount, Currency currency) {
        return Remittance.builder()
            .userId(userId)
            .amount(amount)
            .currency(currency)
            .build();
    }

    public Remittance decline() {
        this.status = RemittanceStatus.DECLINE;
        return this;
    }

    public Remittance accept() {
        this.status = RemittanceStatus.ACCEPT;
        return this;
    }

    public Remittance complete() {
        this.status = RemittanceStatus.COMPLETE;
        this.completedAt = ZonedDateTime.now();
        return this;
    }
}
