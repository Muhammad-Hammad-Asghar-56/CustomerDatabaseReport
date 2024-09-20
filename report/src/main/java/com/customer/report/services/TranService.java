package com.customer.report.services;

import com.customer.report.dto.CustomerShopDTO;
import com.customer.report.dto.NotShowedCustomer;
import com.customer.report.dto.VisitDTO;
import com.customer.report.entity.Shop;
import com.customer.report.entity.Tran;
import com.customer.report.repository.ShopRepository;
import com.customer.report.repository.TranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TranService {

    @Autowired
    private TranRepository transRepo;

    public List<CustomerShopDTO> getNotShowedCustomerTrans(Shop shop) {
        List<Object[]> results = transRepo.getNoShowedUpCustomersByShop(shop.getName());
        List<CustomerShopDTO> customerShopDTOs = new ArrayList<>();

        for (Object[] result : results) {
            CustomerShopDTO dto = makeObject(result, shop);
            customerShopDTOs.add(dto);
        }

        return customerShopDTOs;
    }
    public List<CustomerShopDTO> getAllNotShowedCustomerTrans(Shop shop,String beforeDate) {
        List<Object[]> results = transRepo.getNoShowedUpCustomersByShop(shop.getName(),beforeDate);
        List<CustomerShopDTO> customerShopDTOs = new ArrayList<>();

        for (Object[] result : results) {
            CustomerShopDTO dto = makeObject(result, shop);
            customerShopDTOs.add(dto);
        }

        return customerShopDTOs;
    }

    public List<CustomerShopDTO> getNotShowedCustomerTrans(int offset, int limit, Shop shop, String beforeDate) {
        List<Object[]> results =null;
        results = transRepo.getNoShowedUpCustomersByShop(shop.getName(), beforeDate, limit, offset);
        List<CustomerShopDTO> customerShopDTOs = new ArrayList<>();

        for (Object[] result : results) {
            CustomerShopDTO dto = makeObject(result, shop);
            customerShopDTOs.add(dto);
        }

        return customerShopDTOs;
    }

    public List<CustomerShopDTO> getNotShowedCustomerTransAfterDate(int offset, int limit, Shop shop, String afterDate) {
        List<Object[]> results =null;
        results = transRepo.getNoShowedUpCustomersByShopUsingAfterDate(shop.getName(), afterDate, limit, offset);
        List<CustomerShopDTO> customerShopDTOs = new ArrayList<>();

        for (Object[] result : results) {
            CustomerShopDTO dto = makeObject(result, shop);
            customerShopDTOs.add(dto);
        }

        return customerShopDTOs;
    }

    public List<CustomerShopDTO> getNotShowedCustomerTransAfterDate(Shop shop, String afterDate) {
        List<Object[]> results =null;
        results = transRepo.getNoShowedUpCustomersByShopUsingAfterDate(shop.getName(), afterDate);
        List<CustomerShopDTO> customerShopDTOs = new ArrayList<>();

        for (Object[] result : results) {
            CustomerShopDTO dto = makeObject(result, shop);
            customerShopDTOs.add(dto);
        }

        return customerShopDTOs;
    }

    private CustomerShopDTO makeObject(Object[] result, Shop shop) {
        String cusId = (String) result[0];
        String minTimeCreated = (String) result[2];
        String maxTimeCreated = (String) result[3];
        String status = (String) result[4];
        BigInteger transactionCount = (BigInteger) result[5];

        String firstname, lastname, email, homeno, mobileNo, addr1;
        firstname = (String) result[6];
        lastname = (String) result[7];
        email = (String) result[8];
        homeno = (String) result[9];
        mobileNo = (String) result[10];
        addr1 = (String) result[11];


        CustomerShopDTO dto = new CustomerShopDTO(
                cusId, firstname, lastname, email, minTimeCreated, maxTimeCreated,status,
                transactionCount.toString(),
                homeno, mobileNo, addr1, shop.getLocation(), shop.getName()
        );
        return dto;
    }
}