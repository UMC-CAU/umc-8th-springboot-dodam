package com.umc.demo.converter;

import com.umc.demo.domain.enums.Gender;
import com.umc.demo.domain.enums.PhoneStatus;
import com.umc.demo.domain.enums.Role;
import com.umc.demo.domain.enums.UserStatus;
import com.umc.demo.dto.UserRequestDTO;
import com.umc.demo.dto.UserResponseDTO;
import com.umc.demo.domain.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class UserConverter {

    public static UserResponseDTO.LoginResultDTO toLoginResultDTO(User user){
        return UserResponseDTO.LoginResultDTO.builder()
                .memberId(user.getId())
                .createdAt(user.getCreatedAt())
                .build();
    }

    public static User toUser(UserRequestDTO.LoginDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        Role role = null;

        switch (request.getRole()){
            case 1:
                role = Role.OWNER;
                break;
            case 0:
                role = Role.CUSTOMER;
                break;
        }

        PhoneStatus phoneStatus = null;

        switch (request.getPhoneStatus()){
            case 1:
                phoneStatus = PhoneStatus.AUTHENTICATED;
                break;
            case 0:
                phoneStatus = PhoneStatus.UNAUTHENTICATED;
                break;
        }

        return User.builder()
                .name(request.getName())
                .nickname(request.getNickname())
                .birth(request.getBirth())
                .gender(gender)
                .address(request.getAddress())
                .role(role)
                .email(request.getEmail())
                .phone(request.getPhone())
                .phoneStatus(phoneStatus)
                .userFoods(new ArrayList<>())
                .build();
    }
}