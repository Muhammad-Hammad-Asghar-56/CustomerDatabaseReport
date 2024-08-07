package com.customer.report.services;

import com.customer.report.dto.CustomerShopDTO;
import com.customer.report.dto.NotShowedCustomer;
import com.customer.report.dto.VisitDTO;
import com.customer.report.entity.Datacustomer;
import com.customer.report.entity.Shop;
import com.customer.report.entity.Tran;
import com.customer.report.repository.DatacustomerRepository;
import com.customer.report.repository.TranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class DataCustomerService {
    @Autowired
    private DatacustomerRepository datacustomerRepository;

    @Autowired
    private TranService tranService;

    @Autowired
    private ShopService shopService;



    public Datacustomer getCustomerById(String id) {
        return datacustomerRepository.findById(id).orElse(null);
    }

    public List<CustomerShopDTO> findCustomersNotInTrans(LocalDate startDate, LocalDate endDate) {
        // Fetch all customers
        List<Datacustomer> allCustomers = datacustomerRepository.findAll();

        // Fetch last visits within the specified date range
        List<VisitDTO> lastVisits = tranService.findLastTrans(startDate, endDate);
        Set<Long> lastVisitIds = lastVisits.stream().map(VisitDTO::getCusId)
                .collect(Collectors.toSet());
        List<Datacustomer> noShowedCustomer = allCustomers.stream()
                .filter(customer -> !lastVisitIds.contains(customer.getId().getId()))
                .collect(Collectors.toList());


        List<CustomerShopDTO> customerShopDTOS=new ArrayList<>();
        for (Datacustomer datacustomer : noShowedCustomer) {
//            Tran t = tranService.findLastTrans(datacustomer.getId().getId());
//            List<Tran> cusTrans = tranService.getTrans(datacustomer.getId().getId(),)

//            Shop s = shopService.getShopById(t.getShopId());
//            customerShopDTOS.add(new CustomerShopDTO(datacustomer,t.getShop(),s.getLocation(),t.getTimeCreated()));
        }

        return customerShopDTOS;

    }
    public List<CustomerShopDTO> getNoShowedCustomers(LocalDate startDate, LocalDate endDate) {
        List<NotShowedCustomer> lastVisits = tranService.getNotShowedCustomerTrans(startDate, endDate);
        List<CustomerShopDTO> customerShopDTOS=new ArrayList<>();
        for (NotShowedCustomer notShowedCustomer : lastVisits) {
            String cusId = notShowedCustomer.getCusId();

            Datacustomer dc = getCustomerById(cusId);
            Shop s = shopService.getShopById(notShowedCustomer.getShopId());
            if(dc==null || s==null)
                continue;
            customerShopDTOS.add(new CustomerShopDTO(dc,s,notShowedCustomer.getMaxTimeCreated(),notShowedCustomer.getMinTimeCreated(),notShowedCustomer.getTransactionCount()));
        }
        return customerShopDTOS;
    }
}
