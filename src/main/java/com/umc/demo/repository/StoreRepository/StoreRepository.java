package com.umc.demo.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.umc.demo.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}