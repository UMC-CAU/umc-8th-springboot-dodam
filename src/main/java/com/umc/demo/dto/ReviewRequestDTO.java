package com.umc.demo.dto;

import lombok.Getter;

public class ReviewRequestDTO {
    @Getter
    public static class PostDto{
        Float rating;
        String comment;
        Long userId;
        String url;
    }
}
