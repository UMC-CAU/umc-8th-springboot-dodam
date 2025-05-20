package com.umc.demo.service.UserService;

import com.umc.demo.domain.User;
import com.umc.demo.domain.mapping.UserMission;
import com.umc.demo.dto.UserMissionRequestDTO;
import com.umc.demo.dto.UserRequestDTO;

import java.util.List;

public interface UserMissionCommandService {
    public UserMission ChallengeMission(Long userId, UserMissionRequestDTO.ChallengeDto request);
    public boolean isExist(Long Mission, Long userId);
}
