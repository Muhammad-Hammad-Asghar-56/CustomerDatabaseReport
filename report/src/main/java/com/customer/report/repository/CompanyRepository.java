package com.customer.report.repository;

import com.customer.report.entity.Company;
import com.customer.report.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer> {
}
