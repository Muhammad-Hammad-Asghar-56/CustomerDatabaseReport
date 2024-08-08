package com.customer.report.dto;

import com.customer.report.Helper.LocalDateCustomDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateRangeDTO {
//    @JsonDeserialize(using = LocalDateCustomDeserializer.class)
    private String startDate;
//    @JsonDeserialize(using = LocalDateCustomDeserializer.class)
    private String endDate;
    public DateRangeDTO(String startDate, String endDate) {
        this.startDate =  startDate;
        this.endDate = endDate;
    }
    // Getters and setters
    public LocalDate getStartDate() {
        return LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return LocalDate.parse(startDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
