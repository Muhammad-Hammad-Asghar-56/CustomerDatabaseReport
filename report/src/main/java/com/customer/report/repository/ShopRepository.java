package com.customer.report.repository;

import com.customer.report.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {

    // Using Spring Data JPA's method naming convention
    List<Shop> findByNameStartingWith(String prefix);

    List<Shop> findByLocationStartingWith(String search);

    Shop findById(Long id);

//    // Alternatively, using @Query annotation for custom query
//    @Query("SELECT s FROM Shop s WHERE s.name LIKE %:prefix%")
//    List<Shop> searchByNameStartingWith(@Param("prefix") String prefix);
}
