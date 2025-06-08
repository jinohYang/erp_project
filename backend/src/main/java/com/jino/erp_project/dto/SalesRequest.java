package com.jino.erp_project.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SalesRequest {
    private Long employeeId;      // 등록/담당 직원 ID
    private LocalDate date;       // 매출일
    private Long amount;          // 금액
    private String detail;        // 내용/비고
}
