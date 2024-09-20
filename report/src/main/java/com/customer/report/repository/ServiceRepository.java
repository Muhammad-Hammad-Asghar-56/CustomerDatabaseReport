package com.customer.report.repository;

import com.customer.report.entity.Service;
import com.customer.report.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
