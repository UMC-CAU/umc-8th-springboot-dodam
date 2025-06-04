package com.umc.demo.service.MissionService;

import com.umc.demo.repository.UserRepository.UserMissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MissionQueryServiceImpl implements MissionQueryService {
    private final UserMissionRepository userMissionRepository;

    @Override
    @Transactional
    public boolean isExist(Long value){
        boolean isValid = userMissionRepository.existsById(value);
        return isValid;
    }
}
