package com.umc.demo.dto;

import com.umc.demo.domain.enums.MissionStatus;
import com.umc.demo.domain.enums.isSuccess;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class MissionResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AddResultDTO{
        private Long missionId;
        private LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class toSuccessDTO{
        private Long userMissionId;
        private MissionStatus missionStatus;
        private LocalDateTime createdAt;
        private isSuccess success;
    }

    /**
     * mission 목록 조회 관련 API
     */
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewListDTO {
        List<MissionPreViewDTO> missionList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MissionPreViewDTO {
        Integer point;
        Long cost;
        Integer deadline;
        LocalDateTime createdAt;
    }
}
