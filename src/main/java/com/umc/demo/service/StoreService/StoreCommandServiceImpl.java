package com.umc.demo.service.StoreService;

import com.umc.demo.Exception.Handler.FoodCategoryHandler;
import com.umc.demo.Exception.Handler.StoreHandler;
import com.umc.demo.apiPayLoad.code.status.ErrorStatus;
import com.umc.demo.converter.StoreConverter;
import com.umc.demo.converter.UserConverter;
import com.umc.demo.converter.UserFoodConverter;
import com.umc.demo.domain.FoodCategory;
import com.umc.demo.domain.Region;
import com.umc.demo.domain.Store;
import com.umc.demo.domain.User;
import com.umc.demo.domain.mapping.UserFood;
import com.umc.demo.dto.StoreRequestDTO;
import com.umc.demo.dto.UserRequestDTO;
import com.umc.demo.repository.StoreRepository.StoreRepository;
import com.umc.demo.repository.UserRepository.FoodCategoryRepository;
import com.umc.demo.repository.UserRepository.RegionRepository;
import com.umc.demo.repository.UserRepository.UserFoodRepository;
import com.umc.demo.repository.UserRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {
    private final StoreRepository storeRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final RegionRepository regionRepository;

    @Override
    @Transactional
    public Store AddStore(StoreRequestDTO.AddDto request) {

        FoodCategory foodCategory = foodCategoryRepository.findById(request.getFoodId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
        Region region = regionRepository.findById(request.getRegionId())
                .orElseThrow(() -> new StoreHandler(ErrorStatus.REGION_NOT_FOUND));

        Store newstore = StoreConverter.toStore(request, foodCategory, region);
        storeRepository.save(newstore);

        return newstore;
    }
}
