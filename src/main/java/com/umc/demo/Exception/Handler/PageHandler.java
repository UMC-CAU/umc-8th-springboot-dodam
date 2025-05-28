package com.umc.demo.Exception.Handler;

import com.umc.demo.Exception.GeneralException;
import com.umc.demo.apiPayLoad.code.status.ErrorStatus;

public class PageHandler extends GeneralException {

    public PageHandler(ErrorStatus errorCode) {
        super(errorCode);
    }
}