package com.umc.demo.service.StoreService;

import com.umc.demo.domain.Store;
import com.umc.demo.dto.StoreRequestDTO;

public interface StoreCommandService {
    public Store AddStore(StoreRequestDTO.AddDto request);
}
