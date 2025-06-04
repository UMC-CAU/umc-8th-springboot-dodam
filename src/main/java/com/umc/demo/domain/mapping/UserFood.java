package com.umc.demo.domain.mapping;

import com.umc.demo.domain.FoodCategory;
import com.umc.demo.domain.User;
import com.umc.demo.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "user_food")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFood extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "food_id", nullable = false)
    private FoodCategory foodCategory;

    // 양방향 관계를 정확히 유지하기 위한 메서드
    public void setUser(User user){
        if(this.user != null)
            this.user.getUserFoods().remove(this);  // 기존 관계 제거
        this.user = user;                              // 관계 설정
        user.getUserFoods().add(this);                 // 반대쪽에도 UserFood 추가
    }

    public void setFoodCategory(FoodCategory foodCategory){
        this.foodCategory = foodCategory;
    }
}