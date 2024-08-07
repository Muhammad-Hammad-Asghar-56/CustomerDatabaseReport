package com.customer.report.dto;

import java.time.Instant;
import java.time.LocalDate;

public interface VisitDTO {

    public Long getCusId();
    public Long getShopId();

    public LocalDate getLastVisit();

    public String getShopName();
}
