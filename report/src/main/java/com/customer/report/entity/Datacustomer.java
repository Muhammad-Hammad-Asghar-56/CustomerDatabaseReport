package com.customer.report.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
//import java.sql.Timestamp;
import java.sql.Date;
import java.sql.Timestamp;


@Getter
@Setter
@Entity
@Table(name = "datacustomers",indexes = {
        @Index(name = "search_customer_keyword", columnList = "firstname, lastname, mobile")
})
public class Datacustomer implements Serializable {
    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "Identity", nullable = false)
    private Integer identity;

    @Column(name = "firstname", nullable = false)
    private String firstname;

    @Column(name = "secondname")
    private String secondname;

    @Column(name = "lastname", nullable = false)
    private String lastname;

    @Column(name = "addr1")
    private String addr1;

    @Column(name = "homeno")
    private String homeno;

    @Column(name = "mobile", nullable = false)
    private String mobile;

    @Column(name = "mobileNo", length = 125)
    private String mobileNo;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "ptech")
    private String ptech;

    @Column(name = "Notes", length = 180)
    private String notes;

    @Column(name = "DateCreated")
    private Timestamp dateCreated;
//, columnDefinition = "int UNSIGNED"
    @Column(name = "NotifySMS")
    private Long notifySMS;

    @Column(name = "NotifyEmail")
    private Long notifyEmail;

    @Column(name = "CBy") //, length = 45
    private String cBy;

    @Column(name = "birthday")
    private Date birthday;

//    @ColumnDefault("'0'")
    @Column(name = "LoyalityCounter") // , columnDefinition = "int UNSIGNED"
    private Long loyalityCounter;

//    @ColumnDefault("2")
    @Column(name = "type") //, columnDefinition = "int UNSIGNED"
    private Long type;

//    @ColumnDefault("0")
    @Column(name = "homeservice")
    private Integer homeservice;

//    @ColumnDefault("0")
    @Column(name = "isvip")
    private Integer isvip;

//    @ColumnDefault("'2011-11-13 10:00:00'")
    @Column(name = "vipjoindate")
    private Timestamp vipjoindate;

    @Column(name = "loyaltyno") // , length = 75
    private String loyaltyno;

    @Column(name = "loyaljdate")
    private Date loyaljdate;

//    @ColumnDefault("0")
    @Column(name = "loyaltyconfirm")
    private Integer loyaltyconfirm;

//    @ColumnDefault("0")
    @Column(name = "verified")
    private Integer verified;

//    @ColumnDefault("0")
    @Column(name = "trigside")
    private Integer trigside;

//    @ColumnDefault("0")
    @Column(name = "ignoreDate")
    private Integer ignoreDate;

//    @ColumnDefault("0")
    @Column(name = "isSkipNumber")
    private Integer isSkipNumber;

    @Column(name = "excludeBirthDay")
    private Integer excludeBirthDay;

//    @ColumnDefault("0")
    @Column(name = "memberStatus")
    private Integer memberStatus;

    @ColumnDefault("0")
    @Column(name = "birthdayMonth")
    private Integer birthdayMonth;



//    @ColumnDefault("0")
    @Column(name = "isLead")
    private Integer isLead;

//    @ColumnDefault("0")
    @Column(name = "isEmployee")
    private Integer isEmployee;
}