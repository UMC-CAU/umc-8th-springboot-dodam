package com.umc.demo.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "region")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "region_name", nullable = false, length = 20)
    private String regionName;

    @OneToMany(mappedBy = "region")
    private List<Store> stores = new ArrayList<>();
}