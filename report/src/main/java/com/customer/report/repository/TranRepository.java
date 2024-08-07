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


    List<Tran> findAllByShopId(int id);

    List<Tran> findByTimeCreatedBetweenAndStatus(LocalDate timeCreated, LocalDate timeCreated2, Long status);

    @Query(value = "select innerTrans.CusID as cusId,innerTrans.lastVisit as lastVisit,s.Name as shopName from (SELECT " +
            "        CusID, " +
            "        shop_id, " +
            "        MAX(TimeCreated) AS lastVisit " +
            "    FROM trans " +
            "    WHERE TimeCreated BETWEEN :startDate AND :endDate " +
            "    GROUP BY CusID, shop_id) as innerTrans " +
            "    join shops s on innerTrans.shop_id=s.id ",
            nativeQuery = true)
    List<VisitDTO> findLastVisitByDateRange(@Param("startDate") LocalDate startDate,
                                            @Param("endDate") LocalDate endDate);


//    @Query("SELECT t FROM Tran t WHERE t.cusID = :cusId ORDER BY t.transDate DESC Limit 1")
//    Tran findLastVisitByCusId(@Param("cusId") String cusId);
//
//
//    List<Tran> findAllByCustomerIdAndShopId(Long customerId, Long shopId);

    @Query(
            value =
            "SELECT cusId, shop_id as shopId, MAX(TimeCreated) AS maxTimeCreated, MIN(TimeCreated) AS minTimeCreated, COUNT(shop_id) AS transactionCount "+
            "FROM trans "+
            "WHERE status = 1 "+
            "AND NOT EXISTS ( "+
            "    SELECT 1 "+
            "    FROM trans t "+
            "    WHERE t.cusId = trans.cusId "+
            "    AND t.shop_id = trans.shop_id "+
            "    AND t.TimeCreated BETWEEN :startDate AND :endDate "+
            ") "+
            "GROUP BY cusId, shop_id; "
    ,nativeQuery = true)
    List<NotShowedCustomer> findNoShowedUpCustomer(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}