package com.customer.report.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "servicescategories", indexes = {
        @Index(name = "masterId", columnList = "masterId")
})
public class ServicesCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "masterId", length = 25)
    private String masterId;

    @Column(name = "name")
    private String name;

    @ColumnDefault("0")
    @Column(name = "status")
    private Integer status;

    @Column(name = "displayOrder")
    private Integer displayOrder;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "timecreated", nullable = false)
    private Instant timecreated;

}