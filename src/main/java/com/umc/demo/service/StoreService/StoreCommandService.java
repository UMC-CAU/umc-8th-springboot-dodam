package com.umc.demo.service.StoreService;

import com.umc.demo.domain.Review;
import com.umc.demo.domain.Store;
import com.umc.demo.dto.ReviewRequestDTO;
import com.umc.demo.dto.StoreRequestDTO;

public interface StoreCommandService {
    public Store AddStore(StoreRequestDTO.AddDto request);

    public Review PostReview(Long storeId, ReviewRequestDTO.PostDto request);
}
