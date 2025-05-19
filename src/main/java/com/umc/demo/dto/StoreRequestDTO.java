package com.umc.demo.dto;

import lombok.Getter;
import java.time.LocalTime;

public class StoreRequestDTO {
    @Getter
    public static class AddDto{
        String name;
        String address;
        String photoUrl;
        LocalTime openTime;
        LocalTime closeTime;
        long foodId;
        long regionId;
    }
}
