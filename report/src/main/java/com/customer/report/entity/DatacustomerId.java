package com.customer.report.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.hibernate.annotations.ColumnDefault;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class DatacustomerId implements Serializable {
    private static final long serialVersionUID = 7337347205897366341L;
    @ColumnDefault("''")
    @Column(name = "id", nullable = false, length = 75)
    private String id;

    @ColumnDefault("'1'")
    @Column(name = "Identity", columnDefinition = "int UNSIGNED not null")
    private Long identity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DatacustomerId entity = (DatacustomerId) o;
        return Objects.equals(this.identity, entity.identity) &&
                Objects.equals(this.id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identity, id);
    }

}