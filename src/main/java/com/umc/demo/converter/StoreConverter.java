package com.umc.demo.converter;

import com.umc.demo.domain.FoodCategory;
import com.umc.demo.domain.Region;
import com.umc.demo.domain.Store;
import com.umc.demo.dto.StoreRequestDTO;
import com.umc.demo.dto.StoreResponseDTO;

public class StoreConverter {
    public static StoreResponseDTO.AddResultDTO toAddResultDTO(Store store){
        return StoreResponseDTO.AddResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }

    public static Store toStore(StoreRequestDTO.AddDto request, FoodCategory foodCategory, Region region){

        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .photoUrl(request.getPhotoUrl())
                .openTime(request.getOpenTime())
                .closeTime(request.getCloseTime())
                .foodCategory(foodCategory)
                .region(region)
                .build();
    }
}
