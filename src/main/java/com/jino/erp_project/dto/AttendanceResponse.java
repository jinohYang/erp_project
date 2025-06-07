package com.jino.erp_project.dto;

import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class AttendanceResponse {
    private Long id;
    private Long employeeId;
    private LocalDate date;
    private LocalTime clockIn;
    private LocalTime clockOut;
    private Boolean isAnnualLeave;
    private String note;
}
