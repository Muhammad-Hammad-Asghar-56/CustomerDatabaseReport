package com.customer.report.repository;

import com.customer.report.entity.ServicesCategory;
import com.customer.report.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceCategoryRepository extends JpaRepository<ServicesCategory, Integer> {
}
