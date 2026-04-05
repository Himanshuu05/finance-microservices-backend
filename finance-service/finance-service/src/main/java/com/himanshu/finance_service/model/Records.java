package com.himanshu.finance_service.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Records {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Positive
    private Double amount;

    @Enumerated(EnumType.STRING)
    private Type type;

    @NotBlank
    private String category;

    @NotNull
    private LocalDate date;
    private String description;

    @NotNull
    private Long userId;
}
