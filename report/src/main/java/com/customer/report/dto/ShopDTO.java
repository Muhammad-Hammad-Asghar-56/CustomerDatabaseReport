package com.customer.report.dto;

import com.customer.report.entity.Shop;

public class ShopDTO {


    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String shopName;
    private String location;

    public ShopDTO(Shop shop){
        this.id=shop.getId();
        this.shopName = shop.getName();
        this.location=shop.getLocation();
    }
}
