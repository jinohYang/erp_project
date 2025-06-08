package com.jino.erp_project.service;

import com.jino.erp_project.domain.entity.Department;
import com.jino.erp_project.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public Department create(String name) {
        return departmentRepository.save(Department.builder().name(name).build());
    }

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }
}
