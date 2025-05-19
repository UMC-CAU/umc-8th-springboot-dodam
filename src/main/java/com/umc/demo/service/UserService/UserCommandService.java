package com.umc.demo.service.UserService;

import com.umc.demo.domain.User;
import com.umc.demo.dto.UserRequestDTO;

public interface UserCommandService {
    public User LoginUser(UserRequestDTO.LoginDto request);
}
