// src/main/java/com/jino/erp_project/common/GlobalExceptionHandler.java
package com.jino.erp_project.common;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ApiResponse<?> handleException(Exception ex) {
        // 실제 운영에선 에러 로그 기록 추가
        return ApiResponse.builder()
                .success(false)
                .message(ex.getMessage() != null ? ex.getMessage() : "알 수 없는 오류")
                .data(null)
                .build();
    }
}
