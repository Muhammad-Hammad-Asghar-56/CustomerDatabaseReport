package com.customer.report.dto;

import com.customer.report.entity.Datacustomer;
import com.customer.report.entity.Shop;

import java.time.LocalDate;

public class CustomerShopDTO {
    private String id;
    private String firstname;
    private String lastname;
    private String email;
    private LocalDate firstVisit;
    private int visitCounts;

    private String homeno;
    private String mobileNo;
    private String addr1;

    private String shopLocation;
    public CustomerShopDTO(Datacustomer datacustomer, Shop shop, LocalDate lastVisit,LocalDate firstVisit,int visitCounts) {
        this.id = datacustomer.getId().getId(); // Assuming id is of type String; adjust if needed
        this.firstname = datacustomer.getFirstname();
        this.lastname = datacustomer.getLastname();
        this.email = datacustomer.getEmail();
        this.homeno = datacustomer.getHomeno();
        this.mobileNo = datacustomer.getMobileNo();
        this.shopName = shop.getName();
        this.addr1 = datacustomer.getAddr1();
        this.shopLocation = shop.getLocation();
        this.lastVisit = lastVisit;
        this.firstVisit = firstVisit;
        this.visitCounts = visitCounts;
    }

    public LocalDate getFirstVisit() {
        return firstVisit;
    }

    public void setFirstVisit(LocalDate firstVisit) {
        this.firstVisit = firstVisit;
    }

    public int getVisitCounts() {
        return visitCounts;
    }

    public void setVisitCounts(int visitCounts) {
        this.visitCounts = visitCounts;
    }


    private String shopName;
    private LocalDate lastVisit;

    public String getShopLocation() {
        return shopLocation;
    }

    public void setShopLocation(String shopLocation) {
        this.shopLocation = shopLocation;
    }




    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public LocalDate getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDate lastVisit) {
        this.lastVisit = lastVisit;
    }
    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHomeno() {
        return homeno;
    }

    public void setHomeno(String homeno) {
        this.homeno = homeno;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getAddr1() {
        return addr1;
    }

    public void setAddr1(String addr1) {
        this.addr1 = addr1;
    }
}
