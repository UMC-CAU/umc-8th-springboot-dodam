package com.umc.demo.dto;

import com.umc.demo.domain.enums.MissionStatus;
import lombok.Getter;

public class UserMissionRequestDTO {
    @Getter
    public static class ChallengeDto{
        Long missionId;
    }
}
