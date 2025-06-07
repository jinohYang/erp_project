package com.jino.erp_project.service;

import com.jino.erp_project.domain.entity.Department;
import com.jino.erp_project.domain.entity.Employee;
import com.jino.erp_project.domain.entity.Position;
import com.jino.erp_project.domain.entity.User;
import com.jino.erp_project.dto.EmployeeRequest;
import com.jino.erp_project.dto.EmployeeResponse;
import com.jino.erp_project.repository.DepartmentRepository;
import com.jino.erp_project.repository.EmployeeRepository;
import com.jino.erp_project.repository.PositionRepository;
import com.jino.erp_project.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final DepartmentRepository departmentRepository;
    private final PositionRepository positionRepository;

    // 등록
    public EmployeeResponse create(EmployeeRequest req) {
        User user = null;
        if (req.getUserId() != null) {
            user = userRepository.findById(req.getUserId()).orElse(null);
        }
        Employee employee = Employee.builder()
                .user(user)
                .name(req.getName())
                .phone(req.getPhone())
                .hireDate(req.getHireDate())
                .status(req.getStatus())
                .build();

        if (req.getDepartmentId() != null) {
            Department dept = departmentRepository.findById(req.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("부서 없음"));
            employee.setDepartment(dept);
        }
        if (req.getPositionId() != null) {
            Position pos = positionRepository.findById(req.getPositionId())
                    .orElseThrow(() -> new RuntimeException("직책 없음"));
            employee.setPosition(pos);
        }

        Employee saved = employeeRepository.save(employee);
        return toResponse(saved);
    }

    // 전체 목록
    public List<EmployeeResponse> findAll() {
        return employeeRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // 단일 조회
    public EmployeeResponse findById(Long id) {
        return employeeRepository.findById(id)
                .map(this::toResponse)
                .orElseThrow(() -> new RuntimeException("Not found"));
    }

    // 수정
    public EmployeeResponse update(Long id, EmployeeRequest req) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not found"));
        if (req.getUserId() != null) {
            employee.setUser(userRepository.findById(req.getUserId()).orElse(null));
        }
        employee.setName(req.getName());
        employee.setPhone(req.getPhone());
        employee.setHireDate(req.getHireDate());
        employee.setStatus(req.getStatus());

        if (req.getDepartmentId() != null) {
            Department dept = departmentRepository.findById(req.getDepartmentId())
                    .orElseThrow(() -> new RuntimeException("부서 없음"));
            employee.setDepartment(dept);
        }
        if (req.getPositionId() != null) {
            Position pos = positionRepository.findById(req.getPositionId())
                    .orElseThrow(() -> new RuntimeException("직책 없음"));
            employee.setPosition(pos);
        }

        Employee saved = employeeRepository.save(employee);
        return toResponse(saved);
    }

    // 삭제
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    // Entity → DTO 변환
    private EmployeeResponse toResponse(Employee employee) {
        return EmployeeResponse.builder()
                .id(employee.getId())
                .userId(employee.getUser() != null ? employee.getUser().getId() : null)
                .name(employee.getName())
                .phone(employee.getPhone())
                .hireDate(employee.getHireDate())
                .status(employee.getStatus())
                .build();
    }
}
