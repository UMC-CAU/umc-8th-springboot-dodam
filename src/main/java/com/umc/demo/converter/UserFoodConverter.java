package com.umc.demo.converter;

import com.umc.demo.domain.FoodCategory;
import com.umc.demo.domain.mapping.UserFood;

import java.util.List;
import java.util.stream.Collectors;

public class UserFoodConverter {

    public static List<UserFood> toUserFoodList(List<FoodCategory> foodCategoryList){

        return foodCategoryList.stream()
                .map(foodCategory ->
                        UserFood.builder()
                                .foodCategory(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
