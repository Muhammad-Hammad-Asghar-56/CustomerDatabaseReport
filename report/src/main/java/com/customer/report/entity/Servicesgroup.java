package com.customer.report.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "servicesgroup", indexes = {
        @Index(name = "type", columnList = "type"),
        @Index(name = "status", columnList = "status"),
        @Index(name = "fk_servicegroup_x_brand_idx", columnList = "brand_id"),
        @Index(name = "mainGroupId", columnList = "mainGroupId")
})
public class Servicesgroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "Name", nullable = false, length = 45)
    private String name;

    @ColumnDefault("'0'")
    @Column(name = "Price", columnDefinition = "int UNSIGNED not null")
    private Long price;

    @ColumnDefault("'0'")
    @Column(name = "Ordering", columnDefinition = "int UNSIGNED")
    private Long ordering;

    @ColumnDefault("'1'")
    @Column(name = "type", columnDefinition = "int UNSIGNED not null")
    private Long type;

    @Column(name = "skillid")
    private Integer skillid;

    @ColumnDefault("0")
    @Column(name = "status")
    private Integer status;

    @Column(name = "groupkeyword")
    private String groupkeyword;

    @Column(name = "groupid")
    private Integer groupid;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "modify_date")
    private Instant modifyDate;

    @Column(name = "mainGroupId")
    private Integer mainGroupId;

    @Column(name = "displayName", length = 45)
    private String displayName;

    @Column(name = "displyOrder")
    private Integer displyOrder;

    @OneToMany(mappedBy = "servicesgroup")
    private Set<Service> services = new LinkedHashSet<>();

}