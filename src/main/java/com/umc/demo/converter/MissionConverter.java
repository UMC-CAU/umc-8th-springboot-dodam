package com.umc.demo.converter;

import com.umc.demo.domain.Mission;
import com.umc.demo.domain.Store;
import com.umc.demo.domain.User;
import com.umc.demo.domain.mapping.UserMission;
import com.umc.demo.dto.MissionRequestDTO;
import com.umc.demo.dto.MissionResponseDTO;
import com.umc.demo.dto.UserMissionRequestDTO;
import com.umc.demo.dto.UserMissionResponseDTO;

public class MissionConverter {
    public static MissionResponseDTO.AddResultDTO toAddResultDTO(Mission mission){
        return MissionResponseDTO.AddResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }

    public static Mission toMission(MissionRequestDTO.AddDto request, Store store){

        return Mission.builder()
                .point(request.getPoint())
                .cost(request.getCost())
                .deadline(request.getDeadline())
                .store(store)
                .build();
    }

    public static UserMissionResponseDTO.ChallengeResultDTO toChallengeResultDTO(UserMission userMission){
        return UserMissionResponseDTO.ChallengeResultDTO.builder()
                .userMissionId(userMission.getId())
                .createdAt(userMission.getCreatedAt())
                .build();
    }

    public static UserMission toUserMission(UserMissionRequestDTO.ChallengeDto request, User user, Mission mission){

        return UserMission.builder()
                .mission(mission)
                .user(user)
                .build();
    }
}