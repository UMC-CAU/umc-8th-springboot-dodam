package com.umc.demo.repository.UserRepository;

import com.umc.demo.domain.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
