package com.customer.report.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "timesch")
public class Timesch {
    @Id
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @ColumnDefault("'08:00:00'")
    @Column(name = "realTime")
    private LocalTime realTime;

    @Column(name = "timevalue", length = 45)
    private String timevalue;

    @ColumnDefault("0")
    @Column(name = "isNext")
    private Integer isNext;

    @ColumnDefault("0")
    @Column(name = "displayOrder")
    private Integer displayOrder;

    @OneToMany(mappedBy = "openTime")
    private Set<Shop> shops_OpenTime = new LinkedHashSet<>();

    @OneToMany(mappedBy = "closeTime")
    private Set<Shop> shops_CloseTime = new LinkedHashSet<>();

    @OneToMany(mappedBy = "startTime")
    private Set<Tran> trans = new LinkedHashSet<>();

}