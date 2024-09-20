package com.customer.report.entity;

import javax.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TranId implements Serializable {
    private String id;
    private Integer identity;

    public TranId() {}

    public TranId(String id, Integer identity) {
        this.id = id;
        this.identity = identity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TranId tranId = (TranId) o;
        return Objects.equals(id, tranId.id) &&
                Objects.equals(identity, tranId.identity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, identity);
    }
}
