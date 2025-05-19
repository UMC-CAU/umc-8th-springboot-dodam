package com.umc.demo.service.UserService;

import com.umc.demo.Exception.Handler.FoodCategoryHandler;
import com.umc.demo.converter.UserConverter;
import com.umc.demo.converter.UserFoodConverter;
import com.umc.demo.domain.FoodCategory;
import com.umc.demo.domain.User;
import com.umc.demo.domain.mapping.UserFood;
import com.umc.demo.dto.UserRequestDTO;
import com.umc.demo.repository.UserRepository.*;
import com.umc.demo.apiPayLoad.code.status.ErrorStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final FoodCategoryRepository foodCategoryRepository;
    private final UserFoodRepository userFoodRepository;

    @Override
    @Transactional
    public User LoginUser(UserRequestDTO.LoginDto request) {

        User newUser = UserConverter.toUser(request);
        userRepository.save(newUser);

        List<FoodCategory> foodCategoryList = request.getUserFoods().stream()
                .map(category -> foodCategoryRepository.findById(category)
                        .orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                .collect(Collectors.toList());

        List<UserFood> userFoods = UserFoodConverter.toUserFoodList(foodCategoryList);

        userFoods.forEach(UserFood -> {UserFood.setUser(newUser);});
        userFoodRepository.saveAll(userFoods);

        return newUser;
    }
}