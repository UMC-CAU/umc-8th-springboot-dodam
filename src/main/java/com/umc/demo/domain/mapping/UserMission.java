package com.umc.demo.domain.mapping;

import com.umc.demo.domain.Mission;
import com.umc.demo.domain.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_mission")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserMission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 10)
    private String status;  // "진행완료", "진행중"

    @Column
    private LocalDateTime completedAt;

    @Column(nullable = false)
    private Integer success;  // 성공 = 1, 실패 = 0

    @Column(nullable = false, length = 20)
    private String region;
}