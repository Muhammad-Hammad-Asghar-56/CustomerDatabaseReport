package com.customer.report.dto;

import com.customer.report.entity.Datacustomer;
import com.customer.report.entity.Shop;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CustomerShopDTO {
    private String  id;
    private String firstname;
    private String lastname;
    private String homeno;
    private String email;
    private String firstVisit;
    private String lastVisit;
    private String visitCounts;
    private String shopName;
    private String status;

    public CustomerShopDTO(String id, String firstname, String lastname, String email, String firstVisit, String lastVisit,String status , String visitCounts, String homeno, String mobileNo, String addr1, String shopLocation, String shopName) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.firstVisit = firstVisit;
        this.visitCounts = visitCounts;
        this.homeno = homeno;
        this.mobileNo = mobileNo;
        this.addr1 = addr1;
        this.shopLocation = shopLocation;
        this.shopName = shopName;
        this.status=status;
        this.lastVisit = lastVisit;
    }
    private String mobileNo;
    private String addr1;

    private String shopLocation;
    public CustomerShopDTO(Datacustomer datacustomer, Shop shop, String lastVisit, String firstVisit, String visitCounts) {
        this.id = datacustomer.getId();
        this.firstname = datacustomer.getFirstname();
        this.lastname = datacustomer.getLastname();
        this.email = datacustomer.getEmail();
        this.homeno = datacustomer.getHomeno();
        this.mobileNo = datacustomer.getMobileNo();

        this.shopName = shop!=null? shop.getName():"N/A";
        this.addr1 = datacustomer.getAddr1();
        this.shopLocation = shop!=null? shop.getLocation():"N/A";
        this.lastVisit = lastVisit;
        this.firstVisit = firstVisit;
        this.visitCounts = visitCounts;
    }

    public String getFirstVisit() {
        return firstVisit;
    }

    public void setFirstVisit(String firstVisit) {
        this.firstVisit = firstVisit;
    }

    public String getVisitCounts() {
        return visitCounts;
    }

    public void setVisitCounts(String visitCounts) {
        this.visitCounts = visitCounts;
    }




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

    public String getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(String lastVisit) {
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
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
