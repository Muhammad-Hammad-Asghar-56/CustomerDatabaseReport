package com.customer.report.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "modify_date")
    private Instant modifyDate;

    @OneToMany(mappedBy = "primaryCurrency")
    private Set<Shop> shops = new LinkedHashSet<>();

    @OneToMany(mappedBy = "secondaryCurrency")
    private Set<Shop> shops_Currency = new LinkedHashSet<>();

}