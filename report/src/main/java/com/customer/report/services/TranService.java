package com.customer.report.services;

import com.customer.report.dto.NotShowedCustomer;
import com.customer.report.dto.VisitDTO;
import com.customer.report.entity.Tran;
import com.customer.report.repository.TranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;

@Service
public class TranService {

    @Autowired
    private TranRepository transRepo;

    public List<Tran> getTransByShopId(int id){
        List<Tran> lst=transRepo.findAllByShopId(id);
        lst.stream().forEach(System.out::println);
        return lst;
    }


    public List<Tran> findTransactionsByDateRange(LocalDate startDate, LocalDate endDate) {
        return transRepo.findByTimeCreatedBetweenAndStatus(startDate, endDate, 1L);  // Implement this method in TransRepository
    }

    public List<VisitDTO> findLastTrans(LocalDate startDate, LocalDate endDate) {
        return transRepo.findLastVisitByDateRange(startDate,endDate);
    }



    public List<NotShowedCustomer> getNotShowedCustomerTrans(LocalDate startDate, LocalDate endDate){
        return transRepo.findNoShowedUpCustomer(startDate,endDate);
    }
}

