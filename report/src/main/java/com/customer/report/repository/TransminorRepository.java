package com.customer.report.repository;

import com.customer.report.entity.Transminor;
import com.customer.report.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransminorRepository extends JpaRepository<Transminor, Integer> {
}
