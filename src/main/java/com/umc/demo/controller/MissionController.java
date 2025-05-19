package com.umc.demo.controller;

import com.umc.demo.apiPayLoad.ApiResponse;
import com.umc.demo.converter.MissionConverter;
import com.umc.demo.domain.Mission;
import com.umc.demo.dto.MissionRequestDTO;
import com.umc.demo.dto.MissionResponseDTO;
import com.umc.demo.service.MissionService.MissionCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {
    private final MissionCommandService missionCommandService;

    // 가게 추가
    @PostMapping("/add/stores/{storeId}")
    public ApiResponse<MissionResponseDTO.AddResultDTO> AddMission(@PathVariable Long storeId,
                                                                   @RequestBody @Valid MissionRequestDTO.AddDto request){
        Mission mission = missionCommandService.AddMission(storeId, request);
        return ApiResponse.onSuccess(MissionConverter.toAddResultDTO(mission));
    }
}
