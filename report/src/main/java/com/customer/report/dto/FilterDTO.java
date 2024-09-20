package com.customer.report.dto;


public class FilterDTO {
    public String shopName;
    public String before_from_Date;
    public String after_from_Date;
    public String location;


    public Boolean isAllShop(){
        return shopName.equalsIgnoreCase("all shops");
    }
}
