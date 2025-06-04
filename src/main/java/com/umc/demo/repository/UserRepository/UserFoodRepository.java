package com.umc.demo.repository.UserRepository;

import com.umc.demo.domain.mapping.UserFood;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserFoodRepository extends JpaRepository<UserFood, Long> {
}
