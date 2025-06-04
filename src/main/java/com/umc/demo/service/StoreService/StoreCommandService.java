package com.umc.demo.service.StoreService;

import com.umc.demo.domain.Review;
import com.umc.demo.domain.Store;
import com.umc.demo.dto.ReviewRequestDTO;
import com.umc.demo.dto.StoreRequestDTO;

import java.util.List;

public interface StoreCommandService {
    Store AddStore(StoreRequestDTO.AddDto request);

    Review PostReview(Long storeId, ReviewRequestDTO.PostDto request);

    boolean isExist(Long value);
}
