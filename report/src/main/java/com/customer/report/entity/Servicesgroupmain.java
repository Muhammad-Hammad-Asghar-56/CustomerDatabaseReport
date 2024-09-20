package com.customer.report.entity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "servicesgroupmain")
public class Servicesgroupmain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "display_name")
    private String displayName;

    @ColumnDefault("0")
    @Column(name = "status")
    private Integer status;

    @ColumnDefault("0")
    @Column(name = "shoptype")
    private Integer shoptype;

    @Column(name = "categoryId", length = 25)
    private String categoryId;

    @Column(name = "displayOrder")
    private Integer displayOrder;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "timecreated", nullable = false)
    private Instant timecreated;

}