package com.umc.demo.dto;

import com.umc.demo.validation.annotation.IsChallenging;
import lombok.Getter;

public class UserMissionRequestDTO {
    @Getter
    public static class ChallengeDto{
        @IsChallenging
        Long missionId;
    }
}
