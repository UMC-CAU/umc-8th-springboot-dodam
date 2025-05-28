package com.umc.demo.repository.UserRepository;

import com.umc.demo.domain.FoodCategory;
import com.umc.demo.domain.Mission;
import com.umc.demo.domain.Review;
import com.umc.demo.domain.Store;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    boolean existsById(Long id);
    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
