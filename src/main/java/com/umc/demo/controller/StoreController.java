package com.umc.demo.controller;

import com.umc.demo.apiPayLoad.ApiResponse;
import com.umc.demo.converter.StoreConverter;
import com.umc.demo.domain.Store;
import com.umc.demo.dto.StoreRequestDTO;
import com.umc.demo.dto.StoreResponseDTO;
import com.umc.demo.service.StoreService.StoreCommandService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoreController {

    private final StoreCommandService storeCommandService;

    // 가게 추가
    @PostMapping("/add")
    public ApiResponse<StoreResponseDTO.AddResultDTO> login(@RequestBody @Valid StoreRequestDTO.AddDto request){
        Store store = storeCommandService.AddStore(request);
        return ApiResponse.onSuccess(StoreConverter.toAddResultDTO(store));
    }
}