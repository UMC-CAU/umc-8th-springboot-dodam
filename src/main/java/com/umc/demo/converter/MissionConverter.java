package com.umc.demo.converter;

import com.umc.demo.domain.Mission;
import com.umc.demo.domain.Store;
import com.umc.demo.dto.MissionRequestDTO;
import com.umc.demo.dto.MissionResponseDTO;

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
}