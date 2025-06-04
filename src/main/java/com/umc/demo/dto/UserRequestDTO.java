package com.umc.demo.dto;


import com.umc.demo.validation.annotation.ExistCategories;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;

public class UserRequestDTO {

    @Getter
    public static class LoginDto{
        @NotBlank
        String name;
        @NotNull
        String nickname;
        @NotNull
        LocalDate birth;
        @NotNull
        Integer gender;  // 1 : 남자, 2 : 여자, 0 : none
        @NotNull
        String address;
        @NotNull
        Integer role;       // 1 : 사장, 0 : 고객
        @NotNull
        String email;
        String phone;
        Integer phoneStatus;  // 1 : 활성, 0 : 비활성
        @ExistCategories
        List<Long> userFoods;
    }
}