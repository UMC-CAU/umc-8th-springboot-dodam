package com.umc.demo.dto;

import lombok.Getter;

public class MissionRequestDTO {
    @Getter
    public static class AddDto{
        Integer point;
        Long cost;
        Integer deadline;
    }
}
