package com.jino.erp_project.service;

import com.jino.erp_project.domain.entity.Employee;
import com.jino.erp_project.domain.entity.Sales;
import com.jino.erp_project.dto.SalesRequest;
import com.jino.erp_project.dto.SalesResponse;
import com.jino.erp_project.repository.EmployeeRepository;
import com.jino.erp_project.repository.SalesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalesService {
    private final SalesRepository salesRepository;
    private final EmployeeRepository employeeRepository;

    public SalesResponse create(SalesRequest req) {
        Employee employee = employeeRepository.findById(req.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("직원 없음"));
        Sales sales = Sales.builder()
                .employee(employee)
                .date(req.getDate())
                .amount(req.getAmount())
                .detail(req.getDetail())
                .build();
        return toResponse(salesRepository.save(sales));
    }

    public List<SalesResponse> findAll() {
        return salesRepository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<SalesResponse> findAllByDate(java.time.LocalDate date) {
        return salesRepository.findAllByDate(date).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public List<SalesResponse> findAllByEmployee(Long employeeId) {
        return salesRepository.findAllByEmployeeId(employeeId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        salesRepository.deleteById(id);
    }

    private SalesResponse toResponse(Sales sales) {
        return SalesResponse.builder()
                .id(sales.getId())
                .employeeId(sales.getEmployee() != null ? sales.getEmployee().getId() : null)
                .date(sales.getDate())
                .amount(sales.getAmount())
                .detail(sales.getDetail())
                .build();
    }
}
