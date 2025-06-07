package com.jino.erp_project.domain.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "attendances")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Attendance {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    private LocalDate date;         // 근무일 (ex. 2024-06-06)
    private LocalTime clockIn;      // 출근시간
    private LocalTime clockOut;     // 퇴근시간
    private Boolean isAnnualLeave;  // 연차 사용 여부
    private String note;            // 비고/연차 사유 등
}
