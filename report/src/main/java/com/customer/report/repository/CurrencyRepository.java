package com.customer.report.repository;

import com.customer.report.entity.Currency;
import com.customer.report.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
