package com.customer.report.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "transminor",indexes = {
        @Index(name = "FK996EDE0D9E680D66", columnList = "TransID"),
        @Index(name = "FK_nfi67oynkt7e6iyo55ucm7caf", columnList = "TransID"),
        @Index(name = "appointment_transIDx", columnList = "TransID"),
        @Index(name = "ReserveTimeByTechId_idx", columnList = "TechID, transminordate, shopid, Status"),
        @Index(name = "count_tech_app_idx", columnList = "TechID, transminordate, tech_id"),
        @Index(name = "FK996EDE0D30AFA760", columnList = "TechID"),
        @Index(name = "FK996EDE0DFFF5A27B", columnList = "TechID"),
        @Index(name = "FK_ge1ykf6yf4hxh1p5n1i62llmt", columnList = "TechID"),
        @Index(name = "TechID", columnList = "TechID"),
        @Index(name = "FK996EDE0D4FC78013", columnList = "ServiceID"),
        @Index(name = "FK_bb7e5dq2slitxowbcq4lsyjfv", columnList = "ServiceID"),
        @Index(name = "transminordate", columnList = "transminordate"),
        @Index(name = "FK996EDE0DA81AABC9", columnList = "shopid"),
        @Index(name = "FK_9tqiafaxs94gco7hoymtk24kn", columnList = "shopid"),
        @Index(name = "fk_transminor_x_shops_idx", columnList = "shop_id"),
        @Index(name = "fk_transminor_x_trans_idx", columnList = "trans_id"),
        @Index(name = "fk_transminor_x_technicians_idx", columnList = "tech_id"),
        @Index(name = "fk_transminor_x_timesch_idx", columnList = "service_start_time"),
        @Index(name = "fk_transminor_x_end_timesch_idx", columnList = "service_end_time"),
        @Index(name = "fk_transminor_x_services_idx", columnList = "services_id")
})
public class Transminor {

    @Id
    @Column(length = 75, nullable = false, updatable = false)
    private String id;

    @Column(name = "TransID", length = 75)
    private String transId;

    @Column(name = "TechID", nullable = false)
    private Integer techId;

    @Column(name = "Duration", nullable = false)
    private Integer duration;

    @Column(name = "StartTime", nullable = false)
    private LocalTime startTime;

    @Column(name = "EndTime", nullable = false)
    private LocalTime endTime;

    @Column(name = "RealStartTime")
    private LocalTime realStartTime;

    @Column(name = "RealEndTime")
    private LocalTime realEndTime;

    @Column(name = "StartTimeDiff")
    private Integer startTimeDiff;

    @Column(name = "RealDuration", nullable = false)
    private Integer realDuration;

    @Column(name = "isTechRequested", nullable = false)
    private Integer isTechRequested;

    @Column(name = "Status", nullable = false)
    private Integer status;

    @Column(name = "TimeCreated", nullable = false)
    private Instant timeCreated;

    @Column(name = "ServiceID", nullable = false)
    private Integer serviceId;

    @Column(name = "GroupID", nullable = false)
    private Integer groupId;

    @Column(name = "Identity", nullable = false)
    private Integer identity;

    @Column(name = "transminordate")
    private LocalDate transminorDate;

    @Column(name = "stationid")
    private Integer stationId;

    @Column(name = "shopid")
    private Integer shopId;

    @Column(name = "isaddons")
    private Integer isAddons;

    @Column(name = "iscrossselling")
    private Integer isCrossselling;

    @Column(name = "shop_id")
    private Integer shop_Id;

    @Column(name = "trans_id")
    private String trans_Id;

    @Column(name = "tech_id")
    private Integer tech_Id;

    @Column(name = "service_start_time")
    private Integer serviceStartTime;

    @Column(name = "service_end_time")
    private Integer serviceEndTime;

    @Column(name = "services_id")
    private Integer servicesId;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "modify_date")
    private Instant modifyDate;

    @Column(name = "trans_identity")
    private Integer transIdentity;

    @Column(name = "service_price")
    private Double servicePrice;

    // Add any additional methods or logic if needed
}
