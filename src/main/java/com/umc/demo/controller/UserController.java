package com.umc.demo.controller;

import com.umc.demo.apiPayLoad.ApiResponse;
import com.umc.demo.converter.UserConverter;
import com.umc.demo.domain.User;
import com.umc.demo.dto.UserRequestDTO;
import com.umc.demo.dto.UserResponseDTO;
import com.umc.demo.service.UserService.UserCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserCommandService userCommandService;

    @PostMapping("/login")
    public ApiResponse<UserResponseDTO.LoginResultDTO> login(@RequestBody @Valid UserRequestDTO.LoginDto request){
        User user = userCommandService.LoginUser(request);
        return ApiResponse.onSuccess(UserConverter.toLoginResultDTO(user));
    }
}