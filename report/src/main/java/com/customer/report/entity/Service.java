package com.customer.report.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "services",indexes = {
        @Index(name = "FK5235105E9CC283C6", columnList = "ServiceGroup"),
        @Index(name = "FK5235105EACB09A74", columnList = "ServiceGroup"),
        @Index(name = "FK_h6lr44b17krf8thnrpccwqxqu", columnList = "ServiceGroup"),
        @Index(name = "fk_services_x_servicesgroup_idx", columnList = "servicesgroup_id")
}, uniqueConstraints = {
        @UniqueConstraint(name = "ID", columnNames = {"ID"})
})
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "int UNSIGNED not null")
    private Long id;

    @Column(name = "ServiceName")
    private String serviceName;

    @Column(name = "ServiceGroup", columnDefinition = "int UNSIGNED")
    private Long serviceGroup;

    @Column(name = "Duration", columnDefinition = "int UNSIGNED")
    private Long duration;

    @ColumnDefault("0")
    @Column(name = "Price")
    private Double price;

    @ColumnDefault("'0'")
    @Column(name = "Ordering", columnDefinition = "int UNSIGNED")
    private Long ordering;

    @ColumnDefault("'1'")
    @Column(name = "type", columnDefinition = "int UNSIGNED not null")
    private Long type;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "LastUpdate", nullable = false)
    private Instant lastUpdate;

    @Column(name = "stationid")
    private Integer stationid;

    @Column(name = "skillid")
    private Integer skillid;

    @ColumnDefault("1")
    @Column(name = "isenable")
    private Integer isenable;

    @Column(name = "product_classify")
    private String productClassify;

    @Lob
    @Column(name = "descp")
    private String descp;

    @ColumnDefault("0")
    @Column(name = "equipid")
    private Integer equipid;

    @ColumnDefault("''")
    @Column(name = "servicekeyword")
    private String servicekeyword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "servicesgroup_id")
    private Servicesgroup servicesgroup;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "modify_date")
    private Instant modifyDate;

    @Column(name = "serviceNameArabic")
    private String serviceNameArabic;

    @ColumnDefault("0")
    @Column(name = "enableonlinebooking")
    private Integer enableonlinebooking;

    @ColumnDefault("'0'")
    @Column(name = "includeshops", length = 64)
    private String includeshops;

    @Column(name = "displayOrder")
    private Integer displayOrder;

}