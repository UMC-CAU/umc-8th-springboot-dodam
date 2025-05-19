package com.umc.demo.converter;

import com.umc.demo.domain.*;
import com.umc.demo.dto.ReviewRequestDTO;
import com.umc.demo.dto.ReviewResponseDTO;

public class ReviewConverter {
    public static ReviewResponseDTO.PostResultDTO toPostResultDTO(Review review){
        return ReviewResponseDTO.PostResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

    public static Review toReview(ReviewRequestDTO.PostDto request, Store store, User user){

        return Review.builder()
                .rating(request.getRating())
                .comment(request.getComment())
                .store(store)
                .user(user)
                .build();
    }

    public static ReviewImage toReviewImage(ReviewRequestDTO.PostDto request, Review review){

        return ReviewImage.builder()
                .review(review)
                .url(request.getUrl())
                .build();
    }
}