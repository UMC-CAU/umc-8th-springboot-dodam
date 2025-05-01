package com.umc.demo.domain.mapping;

import com.umc.demo.domain.FoodCategory;
import com.umc.demo.domain.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_food")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFood {

    @Id
    private String id;  // 수동 관리 (예: UUID 등)

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", nullable = false)
    private FoodCategory foodCategory;
}