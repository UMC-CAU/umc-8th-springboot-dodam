package com.umc.demo.controller;

import com.umc.demo.apiPayLoad.ApiResponse;
import com.umc.demo.converter.MissionConverter;
import com.umc.demo.converter.UserConverter;
import com.umc.demo.domain.User;
import com.umc.demo.domain.mapping.UserMission;
import com.umc.demo.dto.*;
import com.umc.demo.service.UserService.UserCommandService;
import com.umc.demo.service.UserService.UserMissionCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserCommandService userCommandService;
    private final UserMissionCommandService userMissionCommandService;

    @PostMapping("/login")
    public ApiResponse<UserResponseDTO.LoginResultDTO> login(@RequestBody @Valid UserRequestDTO.LoginDto request){
        User user = userCommandService.LoginUser(request);
        return ApiResponse.onSuccess(UserConverter.toLoginResultDTO(user));
    }

    @PostMapping("/{userId}/userMission/challenge")
    public ApiResponse<UserMissionResponseDTO.ChallengeResultDTO> ChallengeMission(
            @PathVariable Long userId,
            @RequestBody @Valid UserMissionRequestDTO.ChallengeDto request){
        UserMission usermission = userMissionCommandService.ChallengeMission(userId, request);
        return ApiResponse.onSuccess(MissionConverter.toChallengeResultDTO(usermission));
    }
}