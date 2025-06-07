package com.jino.erp_project.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "expenses")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Expense {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;    // 등록/담당 직원

    private LocalDate date;       // 지출일
    private Long amount;          // 금액
    private String detail;        // 내용/비고
}
