package com.jino.erp_project.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesResponse {
    private Long id;
    private Long employeeId;
    private LocalDate date;
    private Long amount;
    private String detail;
}
