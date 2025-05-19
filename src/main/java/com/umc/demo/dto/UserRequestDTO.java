package com.umc.demo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.umc.demo.domain.enums.Gender;
import com.umc.demo.domain.enums.PhoneStatus;
import com.umc.demo.domain.enums.Role;
import com.umc.demo.domain.enums.UserStatus;
import com.umc.demo.domain.mapping.UserFood;
import com.umc.demo.domain.mapping.UserMission;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class LoginDto{
        String name;
        String nickname;
        LocalDate birth;
        Integer gender;  // 1 : 남자, 2 : 여자, 0 : none
        String address;
        Integer role;       // 1 : 사장, 0 : 고객
        String email;
        String phone;
        Integer phoneStatus;  // 1 : 활성, 0 : 비활성
        List<Long> userFoods;
    }
}