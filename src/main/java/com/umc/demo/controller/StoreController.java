package com.umc.demo.controller;

import com.umc.demo.apiPayLoad.ApiResponse;
import com.umc.demo.converter.ReviewConverter;
import com.umc.demo.converter.StoreConverter;
import com.umc.demo.domain.Review;
import com.umc.demo.domain.Store;
import com.umc.demo.dto.ReviewRequestDTO;
import com.umc.demo.dto.ReviewResponseDTO;
import com.umc.demo.dto.StoreRequestDTO;
import com.umc.demo.dto.StoreResponseDTO;
import com.umc.demo.service.StoreService.StoreCommandService;
import com.umc.demo.validation.annotation.ExistStores;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreCommandService storeCommandService;

    // 가게 추가
    @PostMapping("/add")
    public ApiResponse<StoreResponseDTO.AddResultDTO> AddStore(@RequestBody @Valid StoreRequestDTO.AddDto request){
        Store store = storeCommandService.AddStore(request);
        return ApiResponse.onSuccess(StoreConverter.toAddResultDTO(store));
    }

    @Validated
    @PostMapping("/{storeId}/reviews/add")
    public ApiResponse<ReviewResponseDTO.PostResultDTO> PostReview(
            @PathVariable @ExistStores Long storeId,
            @RequestBody @Valid ReviewRequestDTO.PostDto request){
        Review review = storeCommandService.PostReview(storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toPostResultDTO(review));
    }
}