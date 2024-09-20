//package com.customer.report.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import java.time.Instant;
//import java.time.LocalDate;
//import java.time.LocalTime;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "trans", schema = "customerdatabase", indexes = {
//        @Index(name = "FK697F2A84ECA8902", columnList = "CusID"),
//        @Index(name = "fk_trans_x_datacustomers_idx", columnList = "customer_id"),
//        @Index(name = "fk_trans_x_timesch_idx", columnList = "start_time"),
//        @Index(name = "fk_trans_x_shops_idx", columnList = "shop_id"),
//        @Index(name = "TransDate", columnList = "TransDate"),
//        @Index(name = "gserial", columnList = "gserial"),
//        @Index(name = "index_shop", columnList = "Shop"),
//        @Index(name = "status", columnList = "Status"),
//        @Index(name = "isCallcenterBooking", columnList = "isCallcenterBooking"),
//        @Index(name = "isNotesRead", columnList = "isNotesRead"),
//        @Index(name = "Shop_TransDate", columnList = "Shop, TransDate"),
//        @Index(name = "TimeCreated", columnList = "TimeCreated")
//})
//@IdClass(TranId.class)
//public class Tran {
//
//    @Id
//    @Column(name = "id", length = 75)
//    private String id;
//
//    @Id
//    @Column(name = "Identity", columnDefinition = "int UNSIGNED")
//    private Integer identity;
//
//    @Column(name = "CusID", length = 75)
//    private String cusID;
//
//    @Column(name = "StartTime")
//    private LocalTime startTime;
//
//    @Column(name = "RealStartTime")
//    private LocalTime realStartTime;
//
//    @Column(name = "TimeDiff", columnDefinition = "int UNSIGNED")
//    private Long timeDiff;
//
//    @Column(name = "Status", columnDefinition = "int UNSIGNED not null")
//    private Long status;
//
//    @Column(name = "Shop", nullable = false, length = 90)
//    private String shop;
//
//    @Column(name = "isWalkIn", columnDefinition = "int UNSIGNED not null")
//    private Long isWalkIn;
//
//    @Column(name = "TransDate")
//    private LocalDate transDate;
//
//    @Column(name = "TimeCreated", nullable = false)
//    private Instant timeCreated;
//
//    @Column(name = "IsGroup", columnDefinition = "int UNSIGNED not null")
//    private Long isGroup;
//
//    @Column(name = "GroupMadeBy", nullable = false, length = 90)
//    private String groupMadeBy;
//
//    @Column(name = "GroupID", columnDefinition = "int UNSIGNED not null")
//    private Long groupID;
//
//    @Column(name = "isPaid", columnDefinition = "int UNSIGNED not null")
//    private Long isPaid;
//
//    @Column(name = "UserName", length = 45)
//    private String userName;
//
//    @Column(name = "InvoiceID", length = 75)
//    private String invoiceID;
//
//    @Column(name = "serial", length = 45)
//    private String serial;
//
//    @Column(name = "anyvoid", columnDefinition = "int UNSIGNED not null")
//    private Long anyvoid;
//
//    @Column(name = "isRemsent")
//    private Integer isRemsent;
//
//    @Column(name = "isConfsent")
//    private Integer isConfsent;
//
//    @Column(name = "notes", length = 200)
//    private String notes;
//
//    @Column(name = "laststatusupdate")
//    private Instant laststatusupdate;
//
//    @Column(name = "gserial", length = 75)
//    private String gserial;
//
//    @Column(name = "customer_id", length = 75)
//    private String customerId;
//
//    @Column(name = "customer_identity", columnDefinition = "int UNSIGNED")
//    private Long customerIdentity;
//
//    @Column(name = "start_time", columnDefinition = "int UNSIGNED")
//    private Long startTimeIndex;
//
//    @Column(name = "shop_id", columnDefinition = "int UNSIGNED")
//    private Long shopId;
//
//    @Column(name = "create_date")
//    private Instant createDate;
//
//    @Column(name = "modify_date")
//    private Instant modifyDate;
//
//    @Column(name = "customerarrived")
//    private Integer customerarrived;
//
//    @Column(name = "customerarrivedtime")
//    private Instant customerarrivedtime;
//
//    @Column(name = "isLostOppr")
//    private Integer isLostOppr;
//
//    @Column(name = "isRebooking")
//    private Integer isRebooking;
//
//    @Column(name = "isCallcenterBooking")
//    private Integer isCallcenterBooking;
//
//    @Column(name = "isNotesRead")
//    private Integer isNotesRead;
//
//    // You can also define relationships if needed
//    // @ManyToOne(fetch = FetchType.LAZY)
//    // @JoinColumn(name = "shop_id", insertable = false, updatable = false)
//    // private Shop shop;
//
//    // @ManyToOne(fetch = FetchType.LAZY)
//    // @JoinColumn(name = "start_time", insertable = false, updatable = false)
//    // private Timesch startTimeEntity;
//}

package com.customer.report.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@Entity
@Table(name = "trans", indexes = {
        @Index(name = "FK697F2A84ECA8902", columnList = "CusID"),
        @Index(name = "fk_trans_x_datacustomers_idx", columnList = "customer_id"), 
        @Index(name = "fk_trans_x_shops_idx", columnList = "shop_id"),
        @Index(name = "TransDate", columnList = "TransDate"),
        @Index(name = "gserial", columnList = "gserial"),
        @Index(name = "index_shop", columnList = "Shop"),
        @Index(name = "status", columnList = "Status"),
        @Index(name = "isCallcenterBooking", columnList = "isCallcenterBooking"),
        @Index(name = "isNotesRead", columnList = "isNotesRead"),
        @Index(name = "Shop_TransDate", columnList = "Shop, TransDate"),
        @Index(name = "TimeCreated", columnList = "TimeCreated")
})
@IdClass(TranId.class)
public class Tran {

    @Id
    @Column(name = "id", length = 75)
    private String id;

    @Id
    @Column(name = "Identity", columnDefinition = "int UNSIGNED")
    private Integer identity;

    @Column(name = "CusID", length = 75)
    private String cusID;

    @Column(name = "StartTime")
    private LocalTime startTime;

    @Column(name = "RealStartTime")
    private LocalTime realStartTime;

    @Column(name = "TimeDiff", columnDefinition = "int UNSIGNED")
    private Long timeDiff;

    @Column(name = "Status", columnDefinition = "int UNSIGNED not null")
    private Long status;

    @Column(name = "Shop", nullable = false, length = 90)
    private String shop;

    @Column(name = "isWalkIn", columnDefinition = "int UNSIGNED not null")
    private Long isWalkIn;

    @Column(name = "TransDate")
    private LocalDate transDate;

    @Column(name = "TimeCreated", nullable = false)
    private LocalDate timeCreated;

    @Column(name = "IsGroup", columnDefinition = "int UNSIGNED not null")
    private Long isGroup;

    @Column(name = "GroupMadeBy", nullable = false, length = 90)
    private String groupMadeBy;

    @Column(name = "GroupID", columnDefinition = "int UNSIGNED not null")
    private Long groupID;

    @Column(name = "isPaid", columnDefinition = "int UNSIGNED not null")
    private Long isPaid;

    @Column(name = "UserName", length = 45)
    private String userName;

    @Column(name = "InvoiceID", length = 75)
    private String invoiceID;

    @Column(name = "serial", length = 45)
    private String serial;

    @Column(name = "anyvoid", columnDefinition = "int UNSIGNED not null")
    private Long anyvoid;

    @Column(name = "isRemsent")
    private Integer isRemsent;

    @Column(name = "isConfsent")
    private Integer isConfsent;

    @Column(name = "notes", length = 200)
    private String notes;

    @Column(name = "laststatusupdate")
    private Instant laststatusupdate;

    @Column(name = "gserial", length = 75)
    private String gserial;

    @Column(name = "customer_id", length = 75)
    private String customerId;

    @Column(name = "customer_identity", columnDefinition = "int UNSIGNED")
    private Long customerIdentity;
 
    @Column(name = "shop_id", columnDefinition = "int UNSIGNED")
    private Long shopId;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "modify_date")
    private Instant modifyDate;

    @Column(name = "customerarrived")
    private Integer customerarrived;

    @Column(name = "customerarrivedtime")
    private Instant customerarrivedtime;

    @Column(name = "isLostOppr")
    private Integer isLostOppr;

    @Column(name = "isRebooking")
    private Integer isRebooking;

    @Column(name = "isCallcenterBooking")
    private Integer isCallcenterBooking;

    @Column(name = "isNotesRead")
    private Integer isNotesRead;

    // You can also define relationships if needed
    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "shop_id", insertable = false, updatable = false)
    // private Shop shop;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "start_time", insertable = false, updatable = false)
    // private Timesch startTimeEntity;
}
