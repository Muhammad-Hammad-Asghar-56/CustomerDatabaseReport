package com.customer.report.services;

import com.customer.report.dto.*;
import com.customer.report.entity.Datacustomer;
import com.customer.report.entity.Shop;
import com.customer.report.entity.Tran;
import com.customer.report.repository.DatacustomerRepository;
import com.customer.report.repository.TranRepository;
import org.springframework.beans.NullValueInNestedPathException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class DataCustomerService {
    @Autowired
    private DatacustomerRepository datacustomerRepository;

    @Autowired
    private TranService tranService;

    @Autowired
    private ShopService shopService;

    public List<CustomerShopDTO> getCustomerNotShowed(String shopName) throws Exception {
        Shop s = shopService.getShopByName(shopName);
        if (s == null) {
            throw new Exception("Shop doesn't find in database");
        }
        List<CustomerShopDTO> customerShopDTOS = tranService.getNotShowedCustomerTrans(s);
        return customerShopDTOS;
    }

    public Map<String, Object> getCustomerNotShowed(FilterDTO dto, int pageNum) throws Exception {
        if (dto.isAllShop()) {
            List<CustomerShopDTO> lst = new ArrayList<>();
            List<Shop> shops = shopService.getShops(dto.location);

            // Fetch customers until we have enough or no more shops
            while (lst.size() < 10 && !shops.isEmpty()) {
                Shop s = shops.get(0);
                List<CustomerShopDTO> customers = getNotShowedCustomer(s.getName(), dto.before_from_Date, pageNum);

                // Check if the number of customers fetched is enough
                int requiredSize = 10 - lst.size();
                if (customers.size() > requiredSize) {
                    lst.addAll(customers.subList(0, requiredSize));
                } else {
                    lst.addAll(customers);
                }

                // Check if we have enough customers
                if (lst.size() >= 10) {
                    break;
                }

                // Move to the next shop
                shops.remove(s);
                pageNum = 0; // Reset page number for the next shop
            }

            Map<String, Object> map = new HashMap<>();
            map.put("page", pageNum);
            map.put("list", lst);
            return map;
        }

        // Single shop scenario
        List<CustomerShopDTO> lst = getNotShowedCustomer(dto.shopName, dto.before_from_Date, pageNum);
        Map<String, Object> map = new HashMap<>();
        map.put("page", pageNum);
        map.put("list", lst);
        return map;
    }


    public List<CustomerShopDTO> getCustomerNotShowedBefore(FilterDTO dto) throws Exception {
        if (dto.isAllShop()) {
            List<CustomerShopDTO> lst = new ArrayList<>();
            List<Shop> shops = shopService.getShops(dto.location);

            // Fetch customers until we have enough or no more shops
            while (!shops.isEmpty()) {
                Shop s = shops.get(0);
                List<CustomerShopDTO> customers = tranService.getAllNotShowedCustomerTrans(s, dto.before_from_Date);
                lst.addAll(customers);
                // Move to the next shop
                shops.remove(s);
            }
            return lst;
        }

        Shop shop = shopService.getShopByName(dto.shopName); // Single shop scenario
        return tranService.getAllNotShowedCustomerTrans(shop, dto.before_from_Date);
    }
    public List<CustomerShopDTO> getCustomerNotShowedAfterDate(FilterDTO dto) throws Exception {
        if (dto.isAllShop()) {
            List<CustomerShopDTO> lst = new ArrayList<>();
            List<Shop> shops = shopService.getShops(dto.location);

            while (!shops.isEmpty()) {
                Shop s = shops.get(0);
                List<CustomerShopDTO> customers = tranService.getNotShowedCustomerTransAfterDate(s, dto.after_from_Date);
                lst.addAll(customers);
                // Move to the next shop
                shops.remove(s);
            }
            return lst;
        }

        Shop shop = shopService.getShopByName(dto.shopName); // Single shop scenario
        return tranService.getNotShowedCustomerTransAfterDate(shop, dto.after_from_Date);
    }


    private List<CustomerShopDTO> getNotShowedCustomer(String shopName, String date, int pageNum) throws Exception {
        Shop s = shopService.getShopByName(shopName);
        if (s == null) {
            throw new Exception("Shop doesn't find in database");
        }
        int offset = (pageNum - 1) * 10;
        offset=offset<1? 1:offset;

        List<CustomerShopDTO> customerShopDTOS = tranService.getNotShowedCustomerTrans(offset, 10, s, date);
        return customerShopDTOS;
    }

    public Map<String, Object> getCustomerNotShowedAfterFrom(FilterDTO dto, int pageNum) throws Exception {
        if (dto.isAllShop()) {
            int statingPageNum=pageNum;
            List<CustomerShopDTO> lst = new ArrayList<>();
            List<Shop> shops = shopService.getShops(dto.location);

            // Fetch customers until we have enough or no more shops
            while (lst.size() < 10 && !shops.isEmpty()) {
                Shop s = shops.get(0);
                List<CustomerShopDTO> customers = getNotShowedCustomerAfter(s.getName(), dto.after_from_Date, pageNum);

                // Check if the number of customers fetched is enough
                int requiredSize = 10 - lst.size();
                if (customers.size() > requiredSize) {
                    lst.addAll(customers.subList(0, requiredSize));
                } else {
                    lst.addAll(customers);
                }

                // Check if we have enough customers
                if (lst.size() >= 10) {
                    break;
                }

                // Move to the next shop
                shops.remove(s);
                pageNum = 0; // Reset page number for the next shop
                statingPageNum += pageNum;
            }

            Map<String, Object> map = new HashMap<>();
            map.put("page", statingPageNum);
            map.put("list", lst);
            return map;
        }

        // Single shop scenario
        List<CustomerShopDTO> lst = getNotShowedCustomer(dto.shopName, dto.before_from_Date, pageNum);
        Map<String, Object> map = new HashMap<>();
        map.put("page", pageNum);
        map.put("list", lst);
        return map;

    }

    private List<CustomerShopDTO> getNotShowedCustomerAfter(String name, String afterFromDate, int pageNum) throws Exception {
        Shop s = shopService.getShopByName(name);
        if (s == null) {
            throw new Exception("Shop doesn't find in database");
        }
        int offset = (pageNum - 1) * 10;
        offset=offset<1? 1:offset;
        List<CustomerShopDTO> customerShopDTOS = tranService.getNotShowedCustomerTransAfterDate(offset, 10, s, afterFromDate);
        return customerShopDTOS;
    }
}