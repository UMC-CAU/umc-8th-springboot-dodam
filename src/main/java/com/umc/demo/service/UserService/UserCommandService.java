package com.umc.demo.service.UserService;

import com.umc.demo.domain.User;
import com.umc.demo.dto.UserRequestDTO;

import java.util.List;

public interface UserCommandService {
    public User LoginUser(UserRequestDTO.LoginDto request);
    public boolean isExist(List<Long> values);
}
