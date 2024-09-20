package com.customer.report.repository;

import com.customer.report.dto.NotShowedCustomer;
import com.customer.report.dto.VisitDTO;
import com.customer.report.entity.Tran;
import com.customer.report.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

public interface TranRepository extends JpaRepository<Tran, Integer> {
    @Query(value = "select cus,sh,minTrans,maxTrans,counts,   " +
            "dc.firstname,dc.lastname,dc.email,dc.homeno,dc.mobileNo,dc.addr1   " +
            "   " +
            " from (   " +
            "SELECT    " +
            "    cusId AS cus,    " +
            "    shop AS sh,    " +
            "    DATE_FORMAT(MIN(TransDate), '%Y-%m-%d') AS minTrans,    " +
            "    DATE_FORMAT(MAX(TransDate), '%Y-%m-%d') AS maxTrans,    " +
            "    COUNT(TransDate) AS Counts   " +
            "FROM    " +
            "    trans   " +
            "WHERE    " +
            "    shop = :shopName " +
            "GROUP BY    " +
            "    cusId, shop) subQuery   " +
            "Join datacustomers dc on subQuery.cus = dc.id",
            nativeQuery = true)
    List<Object[]> getNoShowedUpCustomersByShop(@Param("shopName") String shopName);


    @Query(value = "select cus,sh,minTrans,maxTrans,status,counts,   " +
            "dc.firstname,dc.lastname,dc.email,dc.homeno,dc.mobileNo,dc.addr1   " +
            "   " +
            " from (   " +
            "SELECT    " +
            "    cusId AS cus,    " +
            "    shop AS sh,    " +
            "    DATE_FORMAT(MIN(TransDate), '%Y-%m-%d') AS minTrans,    " +
            "    DATE_FORMAT(MAX(TransDate), '%Y-%m-%d') AS maxTrans,    " +
            "    COUNT(TransDate) AS Counts, CASE " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 24 MONTH) THEN '24 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 12 MONTH) THEN 'Last 12 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 9 MONTH) THEN 'Last 9 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 6 MONTH) THEN 'Last 6 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 3 MONTH) THEN 'Last 3 months ago' " +
            "        ELSE 'Within the last 3 months' " +
            "    END AS status   " +
            "FROM    " +
            "    trans   " +
            "WHERE    " +
            "    shop = :shopName " +
            "GROUP BY    " +
            "    cusId, shop " +
            "HAVING  MAX(TransDate) < :beforeDate " +
            "ORDER BY maxTrans DESC " +
            ") subQuery   " +
            "Join datacustomers dc on subQuery.cus = dc.id "+
            "LIMIT :limit OFFSET :offsetNum",
            nativeQuery = true)
    List<Object[]> getNoShowedUpCustomersByShop(@Param("shopName") String shopName,@Param("beforeDate") String beforeDate,@Param("limit") Integer limit,@Param("offsetNum") Integer offset);


    @Query(value = "select cus,sh,minTrans,maxTrans,status,counts,   " +
            "dc.firstname,dc.lastname,dc.email,dc.homeno,dc.mobileNo,dc.addr1   " +
            " from (   " +
            "SELECT    " +
            "    cusId AS cus,    " +
            "    shop AS sh,    " +
            "    DATE_FORMAT(MIN(TransDate), '%Y-%m-%d') AS minTrans,    " +
            "    DATE_FORMAT(MAX(TransDate), '%Y-%m-%d') AS maxTrans,    " +
            "    COUNT(TransDate) AS Counts, CASE " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 24 MONTH) THEN '24 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 12 MONTH) THEN 'Last 12 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 9 MONTH) THEN 'Last 9 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 6 MONTH) THEN 'Last 6 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 3 MONTH) THEN 'Last 3 months ago' " +
            "        ELSE 'Within the last 3 months' " +
            "    END AS status   " +
            "FROM    " +
            "    trans   " +
            "WHERE    " +
            "    shop = :shopName " +
            "GROUP BY    " +
            "    cusId, shop " +
            "HAVING  MAX(TransDate) < :beforeDate " +
            "ORDER BY maxTrans DESC " +
            ") subQuery   " +
            "Join datacustomers dc on subQuery.cus = dc.id ",
            nativeQuery = true)
    List<Object[]> getNoShowedUpCustomersByShop(@Param("shopName") String shopName,@Param("beforeDate") String beforeDate);



    @Query(value = "select cus,sh,minTrans,maxTrans,status,counts,   " +
            "dc.firstname,dc.lastname,dc.email,dc.homeno,dc.mobileNo,dc.addr1   " +
            "   " +
            " from (   " +
            "SELECT    " +
            "    cusId AS cus,    " +
            "    shop AS sh,    " +
            "    DATE_FORMAT(MIN(TransDate), '%Y-%m-%d') AS minTrans,    " +
            "    DATE_FORMAT(MAX(TransDate), '%Y-%m-%d') AS maxTrans,    " +
            "    COUNT(TransDate) AS Counts, CASE " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 24 MONTH) THEN '24 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 12 MONTH) THEN 'Last 12 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 9 MONTH) THEN 'Last 9 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 6 MONTH) THEN 'Last 6 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 3 MONTH) THEN 'Last 3 months ago' " +
            "        ELSE 'Within the last 3 months' " +
            "    END AS status   " +
            "FROM    " +
            "    trans   " +
            "WHERE    " +
            "    shop = :shopName " +
            "GROUP BY    " +
            "    cusId, shop " +
            "HAVING  MAX(TransDate) > :afterDate " +
            "ORDER BY maxTrans DESC " +
            ") subQuery   " +
            "Join datacustomers dc on subQuery.cus = dc.id "+
            "LIMIT :limit OFFSET :offsetNum",
            nativeQuery = true)
    List<Object[]> getNoShowedUpCustomersByShopUsingAfterDate(@Param("shopName") String shopName,@Param("afterDate") String beforeDate,@Param("limit") Integer limit,@Param("offsetNum") Integer offset);


    @Query(value = "select cus,sh,minTrans,maxTrans,status,counts,   " +
            "dc.firstname,dc.lastname,dc.email,dc.homeno,dc.mobileNo,dc.addr1   " +
            "   " +
            " from (   " +
            "SELECT    " +
            "    cusId AS cus,    " +
            "    shop AS sh,    " +
            "    DATE_FORMAT(MIN(TransDate), '%Y-%m-%d') AS minTrans,    " +
            "    DATE_FORMAT(MAX(TransDate), '%Y-%m-%d') AS maxTrans,    " +
            "    COUNT(TransDate) AS Counts, CASE " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 24 MONTH) THEN '24 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 12 MONTH) THEN 'Last 12 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 9 MONTH) THEN 'Last 9 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 6 MONTH) THEN 'Last 6 months ago' " +
            "        WHEN MAX(TransDate) < DATE_SUB(CURDATE(), INTERVAL 3 MONTH) THEN 'Last 3 months ago' " +
            "        ELSE 'Within the last 3 months' " +
            "    END AS status   " +
            "FROM    " +
            "    trans   " +
            "WHERE    " +
            "    shop = :shopName " +
            "GROUP BY    " +
            "    cusId, shop " +
            "HAVING  MAX(TransDate) > :afterDate " +
            "ORDER BY maxTrans DESC " +
            ") subQuery   " +
            "Join datacustomers dc on subQuery.cus = dc.id ",
            nativeQuery = true)
    List<Object[]> getNoShowedUpCustomersByShopUsingAfterDate(@Param("shopName") String shopName,@Param("afterDate") String afterDate);



}