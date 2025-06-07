package com.jino.erp_project.controller;

import com.jino.erp_project.common.ApiResponse;
import com.jino.erp_project.dto.AttendanceResponse;
import com.jino.erp_project.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendances")
@RequiredArgsConstructor
public class AttendanceController {
    private final AttendanceService attendanceService;

    @PostMapping("/clock-in")
    public ApiResponse<AttendanceResponse> clockIn(@RequestParam Long employeeId) {
        AttendanceResponse result = attendanceService.clockIn(employeeId);
        return ApiResponse.<AttendanceResponse>builder()
                .success(true)
                .message("출근 처리 성공")
                .data(result)
                .build();
    }

    @PostMapping("/clock-out")
    public ApiResponse<AttendanceResponse> clockOut(@RequestParam Long employeeId) {
        AttendanceResponse result = attendanceService.clockOut(employeeId);
        return ApiResponse.<AttendanceResponse>builder()
                .success(true)
                .message("퇴근 처리 성공")
                .data(result)
                .build();
    }

    @PostMapping("/annual-leave")
    public ApiResponse<AttendanceResponse> annualLeave(@RequestParam Long employeeId,
                                                       @RequestParam(required = false) String note) {
        AttendanceResponse result = attendanceService.applyAnnualLeave(employeeId, note);
        return ApiResponse.<AttendanceResponse>builder()
                .success(true)
                .message("연차 신청 성공")
                .data(result)
                .build();
    }

    @GetMapping("/employee/{employeeId}")
    public ApiResponse<List<AttendanceResponse>> findAllByEmployee(@PathVariable Long employeeId) {
        List<AttendanceResponse> result = attendanceService.findAllByEmployee(employeeId);
        return ApiResponse.<List<AttendanceResponse>>builder()
                .success(true)
                .message("직원별 근태 목록 조회 성공")
                .data(result)
                .build();
    }

    @GetMapping("/{id}")
    public ApiResponse<AttendanceResponse> findById(@PathVariable Long id) {
        AttendanceResponse result = attendanceService.findById(id);
        return ApiResponse.<AttendanceResponse>builder()
                .success(true)
                .message("근태 상세 조회 성공")
                .data(result)
                .build();
    }
}
