package com.umc.demo.Exception.Handler;

import com.umc.demo.Exception.GeneralException;
import com.umc.demo.apiPayLoad.code.status.ErrorStatus;

public class RequestHandler extends GeneralException {

    public RequestHandler(ErrorStatus errorCode) {
        super(errorCode);
    }
}