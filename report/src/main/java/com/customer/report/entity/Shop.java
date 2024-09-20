package com.customer.report.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.sql.Date;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "shops", indexes = {
        @Index(name = "index_name", columnList = "Name"),
        @Index(name = "FK_l6620r07gcgr5kpou3aoxwd7k", columnList = "brand_id"),
        @Index(name = "fk_shops_x_brand_idx", columnList = "brand_id"),
        @Index(name = "FK_1gb576jsqayb2cfoby99xtuxy", columnList = "city_id"),
        @Index(name = "fk_shops_x_city_idx", columnList = "city_id"),
        @Index(name = "FK_ohgr9l4obsp6o0udm8qkkphon", columnList = "primary_currency"),
        @Index(name = "fk_shops_x_currency1_idx", columnList = "primary_currency"),
        @Index(name = "FK_88s78ij2jjwjg1ejs83ssnt1p", columnList = "secondary_currency"),
        @Index(name = "fk_shops_x_currency2_idx", columnList = "secondary_currency"),
        @Index(name = "fk_shops_x_timesch1_idx", columnList = "open_time"),
        @Index(name = "fk_shops_x_timesch2_idx", columnList = "close_time")
})
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // , columnDefinition = "int UNSIGNED not null"
    private Long id;

    @Column(name = "Name") // , nullable = false, length = 45
    private String name;

    @Column(name = "FullName") // , nullable = false, length = 90
    private String fullName;

    @Column(name = "DisplayName", length = 90)
    private String displayName;

    @Column(name = "Telephone") // , nullable = false, length = 45
    private String telephone;

    @Column(name = "EmailFeedBack") // , nullable = false, length = 45
    private String emailFeedBack;

//    @ColumnDefault("' '")
    @Column(name = "MonthlyTarget") //, nullable = false, length = 45
    private String monthlyTarget;

//    @ColumnDefault("' '")
    @Column(name = "YearlyTarget") // , nullable = false, length = 45
    private String yearlyTarget;

//    @ColumnDefault("' '")
    @Column(name = "DailyTarget") //, nullable = false, length = 45
    private String dailyTarget;

    @Column(name = "StartTimeIndex", columnDefinition = "int unsigned not null")
    private Integer startTimeIndex; // Changed from Long to Integer if the database allows nulls

    @Column(name = "EndTimeIndex", columnDefinition = "int unsigned not null")
    private Integer endTimeIndex; // Similarly, changed from Long to Integer


    // @ColumnDefault("0.000")
    @Column(name = "retaildaily")
    private Double retaildaily;

    // @ColumnDefault("0.000")
    @Column(name = "retailmonthly")
    private Double retailmonthly;

    // @ColumnDefault("0.000")
    @Column(name = "retailyearly")
    private Double retailyearly;

    @Column(name = "shopType")
    private Integer shopType;

    @Column(name = "location") // , length = 100
    private String location;

//    // @ColumnDefault("0.000")
    @Column(name = "nCashTarget")
    private Double nCashTarget;

//    // @ColumnDefault("0.000")
    @Column(name = "giftVoucherTarget")
    private Double giftVoucherTarget;

//    // @ColumnDefault("0.000")
    @Column(name = "heavenRetailTarget")
    private Double heavenRetailTarget;

//    // @ColumnDefault("0.000")
    @Column(name = "massageTarget")
    private Double massageTarget;

    // @ColumnDefault("0.000")
    @Column(name = "waxeblastTarget")
    private Double waxeblastTarget;

    // @ColumnDefault("0.000")
    @Column(name = "handfoottreatmentTarget")
    private Double handfoottreatmentTarget;

    // @ColumnDefault("0.000")
    @Column(name = "bbotarget")
    private Double bbotarget;

    // @ColumnDefault("0.000")
    @Column(name = "avgCustomerPurchase")
    private Double avgCustomerPurchase;

    // @ColumnDefault("0.000")
    @Column(name = "hairServiceTarget")
    private Double hairServiceTarget;

    // @ColumnDefault("0.000")
    @Column(name = "heavenServiceTarget")
    private Double heavenServiceTarget;

    // @ColumnDefault("0.000")
    @Column(name = "nailServiceTarget")
    private Double nailServiceTarget;

    // @ColumnDefault("0.000")
    @Column(name = "bboRetailTarget")
    private Double bboRetailTarget;

    // @ColumnDefault("0.000")
    @Column(name = "lorealRetailTarget")
    private Double lorealRetailTarget;

    // @ColumnDefault("0.000")
    @Column(name = "nailRetailTarget")
    private Double nailRetailTarget;

//    @ColumnDefault("'  '")
    @Column(name = "email", length = 75)
    private String email;

//    @ColumnDefault("'NStyle Intl'")
    @Column(name = "parent", length = 75)
    private String parent;

//    @ColumnDefault("'NStyle'")
    @Column(name = "brand", length = 75)
    private String brand;

//    @ColumnDefault("'U.A.E'")
    @Column(name = "country", length = 75)
    private String country;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "modify_date")
    private Date modifyDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand1;

    @Column(name = "city_id")
    private Integer cityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "primary_currency")
    private Currency primaryCurrency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "secondary_currency")
    private Currency secondaryCurrency;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "open_time")
    private Timesch openTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "close_time")
    private Timesch closeTime;

    @Column(name = "taxtype")
    private Integer taxtype;

    @Column(name = "taxlevel")
    private Integer taxlevel;

    @ColumnDefault("1")
    @Column(name = "active")
    private Integer active;

    @OneToMany(mappedBy = "shop")
    private Set<Tran> trans = new LinkedHashSet<>();

}