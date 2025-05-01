package com.umc.demo.domain;

import com.umc.demo.domain.common.BaseEntity;
import com.umc.demo.domain.mapping.UserFood;
import com.umc.demo.domain.mapping.UserMission;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 20)
    private String Nickname;

    @Column(nullable = false)
    private LocalDate birth;  // yyyy-MM-dd

    @Column
    private Integer gender;  // 남자 0, 여자 1

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false)
    private Integer status;  // 활성화 1, 비활성화 0

    @Column(nullable = false)
    private Integer role;  // 사장 0, 고객 1

    @Column(nullable = false, length = 30)
    private String email;

    @Column(length = 11)
    private String phone;

    @Column(nullable = false)
    private Integer phoneStatus;  // 인증 = 1

    @Column
    private LocalDateTime inactiveDate;

    //양방향 매핑
    @OneToMany(mappedBy = "user")
    private List<UserFood> userFoods = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserMission> userMissions = new ArrayList<>();
}
