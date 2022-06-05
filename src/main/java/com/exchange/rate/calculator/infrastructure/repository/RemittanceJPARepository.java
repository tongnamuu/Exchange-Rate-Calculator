package com.exchange.rate.calculator.infrastructure.repository;

import com.exchange.rate.calculator.domain.entity.Remittance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RemittanceJPARepository extends JpaRepository<Remittance, Long> {
}
