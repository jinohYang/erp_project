package com.jino.erp_project.repository;

import com.jino.erp_project.domain.entity.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<Attendance> findByEmployeeIdAndDate(Long employeeId, LocalDate date);
    List<Attendance> findAllByEmployeeId(Long employeeId);
}
