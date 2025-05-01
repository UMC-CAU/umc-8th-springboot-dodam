package com.umc.demo.domain;

import com.umc.demo.domain.mapping.UserFood;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "food_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FoodCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @OneToMany(mappedBy = "foodCategory")
    private List<Store> stores = new ArrayList<>();

    @OneToMany(mappedBy = "foodCategory")
    private List<UserFood> userFoods = new ArrayList<>();
}