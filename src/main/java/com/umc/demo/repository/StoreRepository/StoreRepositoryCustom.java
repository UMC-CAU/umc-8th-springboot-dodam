package com.umc.demo.repository.StoreRepository;

import com.umc.demo.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}