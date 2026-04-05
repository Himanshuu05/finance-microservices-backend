package com.himanshu.dashboard_service.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RecordsDTO {
    private Long id;
    private Double amount;
    private String type;
    private String category;
    private LocalDate date;
    private String description;
    private Long userId;
}
