package com.umc.demo.domain;

import com.umc.demo.domain.common.BaseEntity;
import com.umc.demo.domain.mapping.UserMission;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mission")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    @Column(nullable = false)
    private Integer point;

    @Column(nullable = false)
    private Long cost;

    @Column(nullable = false)
    private Integer deadline;

    // 양방향 매핑
    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserMission> userMissions = new ArrayList<>();
}