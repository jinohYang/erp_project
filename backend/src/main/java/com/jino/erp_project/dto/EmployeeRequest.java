package com.jino.erp_project.dto;

import lombok.*;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeRequest {
    private Long userId;     // user 엔티티 연동
    private String name;
    private String phone;
    private LocalDate hireDate;
    private String status;

    private Long departmentId; // 부서ID
    private Long positionId;   // 직책ID
}
