package com.umc.demo.domain;

import com.umc.demo.domain.common.BaseEntity;
import com.umc.demo.domain.enums.Gender;
import com.umc.demo.domain.enums.PhoneStatus;
import com.umc.demo.domain.enums.Role;
import com.umc.demo.domain.enums.UserStatus;
import com.umc.demo.domain.mapping.UserFood;
import com.umc.demo.domain.mapping.UserMission;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@DynamicUpdate
@DynamicInsert
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(nullable = false)
    private LocalDate birth;  // yyyy-MM-dd

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    @Builder.Default
    private UserStatus status = UserStatus.ACTIVE;

    @Column(nullable = false)

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false, length = 30)
    private String email;

    @Column(length = 15)
    private String phone;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PhoneStatus phoneStatus;

    private LocalDate inactiveDate;

    //양방향 매핑 : 사용자가 사라지면 사용자 선호 음식과 사용자 미션 테이블도 같이 사라져야 함
    @OneToMany(mappedBy = "user")
    private List<UserFood> userFoods = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserMission> userMissions = new ArrayList<>();
}
