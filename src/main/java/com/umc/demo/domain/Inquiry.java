package com.umc.demo.domain;

import com.umc.demo.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inquiry")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inquiry extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 20)
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String comment;

    @Column(nullable = false)
    private Integer reply;  // 답글 존재 여부 (1 = 있음)

    // 양방향
    @OneToMany(mappedBy = "inquiry", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<InquiryImage> images = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "inquiry", cascade = CascadeType.ALL, orphanRemoval = true)
    private java.util.List<InquiryReply> replies = new java.util.ArrayList<>();
}