package com.jino.erp_project.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AttendanceRequest {
    private Long employeeId;
    private LocalDate date;         // 지정 날짜(출근/퇴근/연차)
    private LocalTime clockIn;
    private LocalTime clockOut;
    private Boolean isAnnualLeave;
    private String note;
}
