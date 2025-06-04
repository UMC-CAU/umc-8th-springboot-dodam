package com.umc.demo.service.UserService;

import com.umc.demo.Exception.Handler.*;
import com.umc.demo.apiPayLoad.code.status.ErrorStatus;
import com.umc.demo.domain.Mission;
import com.umc.demo.domain.Review;
import com.umc.demo.domain.Store;
import com.umc.demo.domain.User;
import com.umc.demo.domain.enums.MissionStatus;
import com.umc.demo.domain.enums.isSuccess;
import com.umc.demo.domain.mapping.UserMission;
import com.umc.demo.repository.UserRepository.ReviewRepository;
import com.umc.demo.repository.UserRepository.UserMissionRepository;
import com.umc.demo.repository.UserRepository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;
    private final ReviewRepository reviewRepository;
    private final UserMissionRepository userMissionRepository;

    @Override
    public Page<Review> getReviewList(Long userId, Integer page){
        page -= 1;
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        Page<Review> ReviewPage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));
        // 요청한 페이지 인덱스가 넘어갔을 경우
        if (page >= ReviewPage.getTotalPages()) {
            throw new PageHandler(ErrorStatus.PAGE_FAULT);
        }
        return ReviewPage;
    }

    @Override
    public Page<Mission> getMissionList(Long userId, Integer status, Integer page){
        page -= 1;
        if (status == null || status < 0 || status > 1){
            throw new RequestHandler(ErrorStatus.WRONG_PARAM);
        }
        MissionStatus missionStatus = MissionStatus.CHALLENGING;   // default 진행중
        if (status == 1){   // 진행 완료
            missionStatus = MissionStatus.COMPLETE;
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        Page<UserMission> userMissions = userMissionRepository.findByUserAndMissionStatus(user, missionStatus, PageRequest.of(page, 10));
        // 요청한 페이지 인덱스가 넘어갔을 경우
        if (page >= userMissions.getTotalPages()) {
            throw new PageHandler(ErrorStatus.PAGE_FAULT);
        }

        List<Mission> missions = userMissions.getContent().stream()
                .map(UserMission::getMission)
                .toList();

        return new PageImpl<>(missions, userMissions.getPageable(), userMissions.getTotalElements());
    }

    @Override
    @Transactional
    public boolean isExist(Long value){
        boolean isValid = userRepository.existsById(value);
        return isValid;
    }

    @Override
    public UserMission postMissionSuccess(Long userId, Long usermissionId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserHandler(ErrorStatus.USER_NOT_FOUND));
        UserMission userMission = userMissionRepository.findById(usermissionId)
                .orElseThrow(() -> new UserHandler(ErrorStatus.MISSION_NOT_FOUND));
        if (!userMission.getUser().equals(user)){
            throw new MissionHandler(ErrorStatus.WRONG_RELATION);
        }
        if (userMission.getMissionStatus() == MissionStatus.COMPLETE){
            throw new MissionHandler(ErrorStatus.ALREADY_SUCCESS);
        }
        userMission.setMissionStatus(MissionStatus.COMPLETE);
        userMission.setSuccess(isSuccess.SUCCESS);
        return userMissionRepository.save(userMission);
    }
}