package com.customer.report.entity;
 
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "brand", indexes = {
        @Index(name = "fk_company_X_brand_idx", columnList = "company_id")
})
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(name = "brand_name", nullable = false)
    private String brandName;

    @Column(name = "create_date")
    private Instant createDate;

    @Column(name = "modify_date")
    private Instant modifyDate;

    @OneToMany(mappedBy = "brand")
    private Set<Servicesgroup> servicesgroups = new LinkedHashSet<>();

    @OneToMany(mappedBy = "brand")
    private Set<Shop> shops = new LinkedHashSet<>();

}