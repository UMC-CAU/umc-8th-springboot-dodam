package com.umc.demo.service.MissionService;

import com.umc.demo.Exception.Handler.StoreHandler;
import com.umc.demo.apiPayLoad.code.status.ErrorStatus;
import com.umc.demo.converter.MissionConverter;
import com.umc.demo.domain.Mission;
import com.umc.demo.domain.Store;
import com.umc.demo.dto.MissionRequestDTO;
import com.umc.demo.repository.StoreRepository.StoreRepository;
import com.umc.demo.repository.UserRepository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {
    private final StoreRepository storeRepository;

    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Mission AddMission(Long storeId, MissionRequestDTO.AddDto request) {

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        Mission newMission = MissionConverter.toMission(request, store);
        missionRepository.save(newMission);

        return newMission;
    }
}
