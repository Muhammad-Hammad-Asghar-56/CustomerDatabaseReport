package com.customer.report.repository;

import com.customer.report.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
    List<Shop> findByLocationStartingWith(String search);
    Shop findById(Long id);
    Shop findByName(String name);

}