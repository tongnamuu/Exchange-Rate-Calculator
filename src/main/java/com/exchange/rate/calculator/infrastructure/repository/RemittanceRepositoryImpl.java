package com.exchange.rate.calculator.infrastructure.repository;

import com.exchange.rate.calculator.domain.entity.Remittance;
import com.exchange.rate.calculator.domain.repository.RemittanceRepository;
import org.springframework.stereotype.Repository;

@Repository
public class RemittanceRepositoryImpl implements RemittanceRepository {
    private final RemittanceJPARepository remittanceJPARepository;

    public RemittanceRepositoryImpl(
        RemittanceJPARepository remittanceJPARepository) {
        this.remittanceJPARepository = remittanceJPARepository;
    }


    @Override
    public Remittance save(Remittance remittance) {
        return remittanceJPARepository.save(remittance);
    }
}
