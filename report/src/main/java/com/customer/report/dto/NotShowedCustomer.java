package com.customer.report.dto;

import com.customer.report.entity.Shop;
import com.customer.report.services.ShopService;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class NotShowedCustomer {
    private String cusId;
    private String shopName;
    private Timestamp maxTimeCreated;
    private Timestamp minTimeCreated;
    private Long transactionCount;

    // Constructor, getters, and setters

    public NotShowedCustomer(String cusId, String shopName, Timestamp maxTimeCreated, Timestamp minTimeCreated, Long transactionCount) {
        this.cusId = cusId;
        this.shopName = shopName;
        this.maxTimeCreated = maxTimeCreated;
        this.minTimeCreated = minTimeCreated;
        this.transactionCount = transactionCount;
    }

    public NotShowedCustomer(String cusId, String shopName, Date maxTimeCreated, Date minTimeCreated, Long transactionCount) {
        this.cusId = cusId;
        this.shopName = shopName;
        this.maxTimeCreated = new Timestamp(maxTimeCreated.getTime());
        this.minTimeCreated = new Timestamp(minTimeCreated.getTime());
        this.transactionCount = transactionCount;
    }


    public String getCusId(){return cusId;};
    public String getShopName(){return shopName;};
    public Timestamp getMaxTimeCreated(){return maxTimeCreated;};
    public Timestamp getMinTimeCreated(){return minTimeCreated;};
    public Long getTransactionCount(){return transactionCount;};
}
