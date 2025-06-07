package com.jino.erp_project.controller;

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

    // 출근
    @PostMapping("/clock-in")
    public AttendanceResponse clockIn(@RequestParam Long employeeId) {
        return attendanceService.clockIn(employeeId);
    }

    // 퇴근
    @PostMapping("/clock-out")
    public AttendanceResponse clockOut(@RequestParam Long employeeId) {
        return attendanceService.clockOut(employeeId);
    }

    // 연차신청
    @PostMapping("/annual-leave")
    public AttendanceResponse annualLeave(@RequestParam Long employeeId,
                                          @RequestParam(required = false) String note) {
        return attendanceService.applyAnnualLeave(employeeId, note);
    }

    // 직원별 근태 목록 조회
    @GetMapping("/employee/{employeeId}")
    public List<AttendanceResponse> findAllByEmployee(@PathVariable Long employeeId) {
        return attendanceService.findAllByEmployee(employeeId);
    }

    // 근태 상세 조회
    @GetMapping("/{id}")
    public AttendanceResponse findById(@PathVariable Long id) {
        return attendanceService.findById(id);
    }
}
