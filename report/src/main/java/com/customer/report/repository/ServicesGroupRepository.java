package com.customer.report.repository;

import com.customer.report.entity.Servicesgroup;
import com.customer.report.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicesGroupRepository extends JpaRepository<Servicesgroup, Integer> {
}
