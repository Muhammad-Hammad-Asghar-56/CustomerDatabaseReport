package com.customer.report.dto;

import java.time.LocalDate;

public interface NotShowedCustomer {

    String getCusId();
    Long getShopId();
    LocalDate getMaxTimeCreated();
    LocalDate getMinTimeCreated();
    int getTransactionCount();
}
