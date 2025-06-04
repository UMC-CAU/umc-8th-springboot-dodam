package com.umc.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class UserResponseDTO {

    /**
     * 정적 중첩 클래스
     * 사용자 관련 응답이라는 상위 그룹 내에 하위 클래스들을 정의
     * 응답 목적별 DTO를 한 곳에 정리
     * 외부 클래스 인스턴스에 종속되지 않고 독립적으로 사용하기 위해 static으로 정의
     */
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginResultDTO{
        private Long userId;
        private LocalDateTime createdAt;
    }
}