package com.exchange.rate.calculator.domain.repository;

import com.exchange.rate.calculator.domain.entity.Remittance;

public interface RemittanceRepository {
    Remittance save(Remittance remittance);
}
