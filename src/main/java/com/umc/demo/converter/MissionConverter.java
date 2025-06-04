package com.umc.demo.converter;

import com.umc.demo.domain.Mission;
import com.umc.demo.domain.Review;
import com.umc.demo.domain.Store;
import com.umc.demo.domain.User;
import com.umc.demo.domain.mapping.UserMission;
import com.umc.demo.dto.*;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static MissionResponseDTO.toSuccessDTO toSuccess (UserMission userMission){

        return new MissionResponseDTO.toSuccessDTO(
                userMission.getId(),
                userMission.getMissionStatus(),
                userMission.getUpdatedAt(),
                userMission.getSuccess()
        );
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

    public static MissionResponseDTO.MissionPreViewDTO missionPreViewDTO(Mission mission){
        return MissionResponseDTO.MissionPreViewDTO.builder()
                .point(mission.getPoint())
                .cost(mission.getCost())
                .deadline(mission.getDeadline())
                .createdAt(mission.getCreatedAt())
                .build();
    }
    public static MissionResponseDTO.MissionPreViewListDTO missionPreViewListDTO(Page<Mission> missionList){
        List<MissionResponseDTO.MissionPreViewDTO> missionPreViewDTOList = missionList.stream()
                .map(MissionConverter::missionPreViewDTO).collect(Collectors.toList());

        return MissionResponseDTO.MissionPreViewListDTO.builder()
                .isLast(missionList.isLast())
                .isFirst(missionList.isFirst())
                .totalPage(missionList.getTotalPages())
                .totalElements(missionList.getTotalElements())
                .listSize(missionPreViewDTOList.size())
                .missionList(missionPreViewDTOList)
                .build();
    }
}