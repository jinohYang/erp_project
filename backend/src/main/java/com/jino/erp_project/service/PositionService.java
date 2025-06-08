package com.jino.erp_project.service;

import com.jino.erp_project.domain.entity.Position;
import com.jino.erp_project.repository.PositionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PositionService {
    private final PositionRepository positionRepository;

    public Position create(String name) {
        return positionRepository.save(Position.builder().name(name).build());
    }

    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    public void delete(Long id) {
        positionRepository.deleteById(id);
    }
}
