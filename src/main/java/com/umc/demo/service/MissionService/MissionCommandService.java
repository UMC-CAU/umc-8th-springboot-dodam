package com.umc.demo.service.MissionService;

import com.umc.demo.domain.Mission;
import com.umc.demo.domain.Store;
import com.umc.demo.dto.MissionRequestDTO;
import com.umc.demo.dto.StoreRequestDTO;

public interface MissionCommandService {
    Mission AddMission(Long storeId, MissionRequestDTO.AddDto request);
}
