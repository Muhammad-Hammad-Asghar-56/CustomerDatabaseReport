package com.customer.report.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "users", schema = "customerdatabase", indexes = {
        @Index(name = "username", columnList = "username")
}, uniqueConstraints = {
        @UniqueConstraint(name = "employee", columnNames = {"employee"})
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "username", nullable = false, length = 45)
    private String username;

    @Column(name = "UserFullName", nullable = false, length = 45)
    private String userFullName;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "datecreated", nullable = false)
    private Instant datecreated;

    @Column(name = "ShopID", columnDefinition = "int UNSIGNED not null")
    private Long shopID;

    @ColumnDefault("'0'")
    @Column(name = "ISCashier", columnDefinition = "int UNSIGNED not null")
    private Long iSCashier;

    @Column(name = "ShopName", nullable = false, length = 45)
    private String shopName;

    @ColumnDefault("'1'")
    @Column(name = "IsEnable", columnDefinition = "int UNSIGNED not null")
    private Long isEnable;

    @ColumnDefault("'0'")
    @Column(name = "CanMakeDiscount", columnDefinition = "int UNSIGNED not null")
    private Long canMakeDiscount;

    @ColumnDefault("'0'")
    @Column(name = "viweraccess", columnDefinition = "int UNSIGNED not null")
    private Long viweraccess;

    @Column(name = "modifiedDate")
    private Instant modifiedDate;

    @ColumnDefault("0")
    @Column(name = "employeeId")
    private Integer employeeId;

    @Column(name = "employee")
    private Integer employee;

    @Column(name = "securitiesgroup")
    private Integer securitiesgroup;

}