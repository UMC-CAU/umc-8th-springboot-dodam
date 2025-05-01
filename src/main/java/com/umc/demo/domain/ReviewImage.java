package com.umc.demo.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "review_image")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReviewImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;

    @Column(nullable = false, length = 100)
    private String url;
}