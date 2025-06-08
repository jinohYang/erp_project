package com.jino.erp_project.service;

import com.jino.erp_project.domain.entity.Attendance;
import com.jino.erp_project.domain.entity.Employee;
import com.jino.erp_project.dto.AttendanceRequest;
import com.jino.erp_project.dto.AttendanceResponse;
import com.jino.erp_project.repository.AttendanceRepository;
import com.jino.erp_project.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final EmployeeRepository employeeRepository;

    // 출근 처리
    public AttendanceResponse clockIn(Long employeeId) {
        LocalDate today = LocalDate.now();
        Attendance attendance = attendanceRepository.findByEmployeeIdAndDate(employeeId, today)
                .orElseGet(() -> Attendance.builder()
                        .employee(employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("직원 없음")))
                        .date(today)
                        .build()
                );
        attendance.setClockIn(java.time.LocalTime.now());
        attendance.setIsAnnualLeave(false);
        Attendance saved = attendanceRepository.save(attendance);
        return toResponse(saved);
    }

    // 퇴근 처리
    public AttendanceResponse clockOut(Long employeeId) {
        LocalDate today = LocalDate.now();
        Attendance attendance = attendanceRepository.findByEmployeeIdAndDate(employeeId, today)
                .orElseThrow(() -> new RuntimeException("오늘 출근기록 없음"));
        attendance.setClockOut(java.time.LocalTime.now());
        Attendance saved = attendanceRepository.save(attendance);
        return toResponse(saved);
    }

    // 연차 신청
    public AttendanceResponse applyAnnualLeave(Long employeeId, String note) {
        LocalDate today = LocalDate.now();
        Attendance attendance = attendanceRepository.findByEmployeeIdAndDate(employeeId, today)
                .orElseGet(() -> Attendance.builder()
                        .employee(employeeRepository.findById(employeeId).orElseThrow(() -> new RuntimeException("직원 없음")))
                        .date(today)
                        .build()
                );
        attendance.setIsAnnualLeave(true);
        attendance.setNote(note);
        Attendance saved = attendanceRepository.save(attendance);
        return toResponse(saved);
    }

    // 근태 목록 조회 (직원별)
    public List<AttendanceResponse> findAllByEmployee(Long employeeId) {
        return attendanceRepository.findAllByEmployeeId(employeeId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // 개별 근태 상세 조회
    public AttendanceResponse findById(Long id) {
        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("근태 없음"));
        return toResponse(attendance);
    }

    private AttendanceResponse toResponse(Attendance attendance) {
        return AttendanceResponse.builder()
                .id(attendance.getId())
                .employeeId(attendance.getEmployee().getId())
                .date(attendance.getDate())
                .clockIn(attendance.getClockIn())
                .clockOut(attendance.getClockOut())
                .isAnnualLeave(attendance.getIsAnnualLeave())
                .note(attendance.getNote())
                .build();
    }
}
