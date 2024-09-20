package com.customer.report.repository;

import com.customer.report.entity.Timesch;
import com.customer.report.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSchRepository extends JpaRepository<Timesch, Integer> {
}
