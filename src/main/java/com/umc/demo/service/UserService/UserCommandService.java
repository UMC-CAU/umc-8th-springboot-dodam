package com.umc.demo.service.UserService;

import com.umc.demo.domain.User;
import com.umc.demo.dto.UserRequestDTO;

import java.util.List;

public interface UserCommandService {
    User LoginUser(UserRequestDTO.LoginDto request);
    boolean isExist(List<Long> values);
}
