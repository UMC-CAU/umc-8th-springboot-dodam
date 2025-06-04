package com.umc.demo.Exception.Handler;

import com.umc.demo.Exception.GeneralException;
import com.umc.demo.apiPayLoad.code.status.ErrorStatus;

public class MissionHandler extends GeneralException {

    public MissionHandler(ErrorStatus errorCode) {
        super(errorCode);
    }
}