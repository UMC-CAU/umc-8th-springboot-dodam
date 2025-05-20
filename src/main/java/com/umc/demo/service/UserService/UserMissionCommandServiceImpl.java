package com.umc.demo.service.UserService;

import com.umc.demo.Exception.Handler.MissionHandler;
import com.umc.demo.Exception.Handler.StoreHandler;
import com.umc.demo.Exception.Handler.UserHandler;
import com.umc.demo.apiPayLoad.code.status.ErrorStatus;
import com.umc.demo.converter.MissionConverter;
import com.umc.demo.domain.Mission;
import com.umc.demo.domain.Store;
import com.umc.demo.domain.User;
import com.umc.demo.domain.mapping.UserMission;
import com.umc.demo.dto.MissionRequestDTO;
import com.umc.demo.dto.UserMissionRequestDTO;
import com.umc.demo.repository.StoreRepository.StoreRepository;
import com.umc.demo.repository.UserRepository.MissionRepository;
import com.umc.demo.repository.UserRepository.UserMissionRepository;
import com.umc.demo.repository.UserRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserMissionCommandServiceImpl implements UserMissionCommandService {
    private final UserRepository userRepository;
    private final MissionRepository missionRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    @Transactional
    public UserMission ChallengeMission(Long userId, UserMissionRequestDTO.ChallengeDto request) {

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new MissionHandler(ErrorStatus.MISSION_NOT_FOUND));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));

        UserMission newuserMission = MissionConverter.toUserMission(request, user, mission);
        userMissionRepository.save(newuserMission);

        return newuserMission;
    }
}
