package com.umc.demo.Exception.Handler;

import com.umc.demo.Exception.GeneralException;
import com.umc.demo.apiPayLoad.code.status.ErrorStatus;

public class UserHandler extends GeneralException {

    public UserHandler(ErrorStatus errorCode) {
        super(errorCode);
    }
}