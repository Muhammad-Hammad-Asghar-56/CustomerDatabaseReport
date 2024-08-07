package com.customer.report.repository;

import com.customer.report.entity.Datacustomer;
import com.customer.report.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DatacustomerRepository extends JpaRepository<Datacustomer, String> {
//    @Query(value = "Select * from datacustomers where id=:id",nativeQuery = true);
//    Optional<Datacustomer> findById(@Param("id") Integer id);

    @Query(value = "SELECT * FROM datacustomers WHERE id = :id", nativeQuery = true)
    Optional<Datacustomer> findById(@Param("id") String id);
}
