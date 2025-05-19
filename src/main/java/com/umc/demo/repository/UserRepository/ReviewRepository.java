package com.umc.demo.repository.UserRepository;

import com.umc.demo.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
