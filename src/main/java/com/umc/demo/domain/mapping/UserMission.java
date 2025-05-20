package com.umc.demo.domain.mapping;

import com.umc.demo.domain.FoodCategory;
import com.umc.demo.domain.Mission;
import com.umc.demo.domain.User;
import com.umc.demo.domain.common.BaseEntity;
import com.umc.demo.domain.enums.MissionStatus;
import com.umc.demo.domain.enums.isSuccess;
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
public class UserMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private MissionStatus missionStatus = MissionStatus.CHALLENGING;

    private LocalDateTime completedAt;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private isSuccess success = isSuccess.NOT_YET;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // 양방향 관계를 정확히 유지하기 위한 메서드
    public void setUser(User user){
        if(this.user != null)
            this.user.getUserMissions().remove(this);
        this.user = user;
        user.getUserMissions().add(this);
    }

    public void setMission(Mission mission){
        this.mission = mission;
    }
}