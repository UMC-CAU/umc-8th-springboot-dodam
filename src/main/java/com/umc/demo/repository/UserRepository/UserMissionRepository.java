package com.umc.demo.repository.UserRepository;

import com.umc.demo.domain.Mission;
import com.umc.demo.domain.User;
import com.umc.demo.domain.enums.MissionStatus;
import com.umc.demo.domain.mapping.UserMission;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
    boolean existsByUserIdAndMissionIdAndMissionStatus(Long missionId, Long userId, MissionStatus missionStatus);
    Page<UserMission> findByUserAndMissionStatus(User user, MissionStatus status, PageRequest pageRequest);

}
