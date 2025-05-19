package com.umc.demo.repository.UserRepository;

import com.umc.demo.domain.FoodCategory;
import com.umc.demo.domain.Mission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
}
