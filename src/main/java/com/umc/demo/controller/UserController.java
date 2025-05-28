package com.umc.demo.controller;

import com.umc.demo.apiPayLoad.ApiResponse;
import com.umc.demo.converter.MissionConverter;
import com.umc.demo.converter.ReviewConverter;
import com.umc.demo.converter.UserConverter;
import com.umc.demo.domain.Mission;
import com.umc.demo.domain.Review;
import com.umc.demo.domain.User;
import com.umc.demo.domain.enums.MissionStatus;
import com.umc.demo.domain.mapping.UserMission;
import com.umc.demo.dto.*;
import com.umc.demo.service.UserService.UserCommandService;
import com.umc.demo.service.UserService.UserMissionCommandService;
import com.umc.demo.service.UserService.UserQueryService;
import com.umc.demo.validation.annotation.CheckPage;
import com.umc.demo.validation.annotation.ExistUserMissions;
import com.umc.demo.validation.annotation.ExistUsers;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@Validated
public class UserController {

    private final UserCommandService userCommandService;
    private final UserMissionCommandService userMissionCommandService;
    private final UserQueryService userQueryService;

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

    @GetMapping("/{userId}/reviews/list")
    @Operation(summary = "나의 리뷰 목록 조회 API",description = "내가 작성한 리뷰를 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "사용자의 아이디, path variable 입니다!")
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewList(@ExistUsers @PathVariable(name = "userId") Long userId, @RequestParam(name = "page") @CheckPage Integer page){
        Page<Review> reviewList = userQueryService.getReviewList(userId,page);
        return ApiResponse.onSuccess(ReviewConverter.reviewPreViewListDTO(reviewList));
    }

    @GetMapping("/{userId}/missions/challenging/list")
    @Operation(summary = "나의 진행 중인 미션 조회 API",description = "내가 진행 중인 미션 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "사용자의 아이디, path variable 입니다!"),
            @Parameter(name = "status", description = "미션 상태 정보입니다. 진행 중이면 0, 진행 완료이면 1을 입력해주세요")
    })
    public ApiResponse<MissionResponseDTO.MissionPreViewListDTO> getUserMissionList(@ExistUsers @PathVariable(name = "userId") Long userId, @RequestParam(name = "status") Integer status, @RequestParam(name = "page") @CheckPage Integer page){
        Page<Mission> missionList = userQueryService.getMissionList(userId,status, page);
        return ApiResponse.onSuccess(MissionConverter.missionPreViewListDTO(missionList));
    }

    @PostMapping("/{userId}/missions/{userMissionId}/success")
    @Operation(summary = "미션 성공 요청 API",description = "진행 중이던 미션의 성공 요청하는 API이입니다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "사용자의 아이디, path variable 입니다!"),
            @Parameter(name = "userMissionId", description = "성공 요청을 보낼 미션의 아이디, path variable 입니다!")
    })
    public ApiResponse<MissionResponseDTO.toSuccessDTO> postMissionSuccess (@ExistUsers @PathVariable(name = "userId") Long userId, @ExistUserMissions @PathVariable(name = "userMissionId") Long userMissionId){
        UserMission userMission = userQueryService.postMissionSuccess(userId, userMissionId);
        return ApiResponse.onSuccess(MissionConverter.toSuccess(userMission));
    }
}