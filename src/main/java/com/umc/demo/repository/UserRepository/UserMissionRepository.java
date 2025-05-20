package com.umc.demo.repository.UserRepository;

import com.umc.demo.domain.enums.MissionStatus;
import com.umc.demo.domain.mapping.UserMission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    boolean existsByUserIdAndMissionIdAndMissionStatus(Long missionId, Long userId, MissionStatus missionStatus);
}
