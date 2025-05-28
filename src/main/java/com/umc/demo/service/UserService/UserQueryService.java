package com.umc.demo.service.UserService;

import com.umc.demo.domain.Mission;
import com.umc.demo.domain.Review;
import com.umc.demo.domain.mapping.UserMission;
import org.springframework.data.domain.Page;

public interface UserQueryService {
    Page<Review>  getReviewList(Long storeId, Integer page);
    Page<Mission> getMissionList(Long userId,Integer status, Integer page);
    UserMission postMissionSuccess(Long userId, Long usermissionId);
    boolean isExist(Long value);
}
