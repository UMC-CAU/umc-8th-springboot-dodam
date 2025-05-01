package com.umc.demo.domain;

import com.umc.demo.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "inquiry_reply")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InquiryReply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inquiry_id", nullable = false)
    private Inquiry inquiry;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String comment;
}