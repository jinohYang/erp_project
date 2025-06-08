package com.jino.erp_project.controller;

import com.jino.erp_project.common.ApiResponse;
import com.jino.erp_project.domain.entity.Position;
import com.jino.erp_project.service.PositionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/positions")
@RequiredArgsConstructor
public class PositionController {
    private final PositionService positionService;

    @PostMapping
    public ApiResponse<Position> create(@RequestParam String name) {
        Position pos = positionService.create(name);
        return ApiResponse.<Position>builder()
                .success(true)
                .message("직책 등록 성공")
                .data(pos)
                .build();
    }

    @GetMapping
    public ApiResponse<List<Position>> findAll() {
        List<Position> result = positionService.findAll();
        return ApiResponse.<List<Position>>builder()
                .success(true)
                .message("직책 목록 조회 성공")
                .data(result)
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        positionService.delete(id);
        return ApiResponse.<Void>builder()
                .success(true)
                .message("직책 삭제 성공")
                .data(null)
                .build();
    }
}
