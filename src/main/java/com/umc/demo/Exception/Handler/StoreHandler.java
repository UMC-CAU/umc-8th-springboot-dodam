package com.umc.demo.Exception.Handler;

import com.umc.demo.Exception.GeneralException;
import com.umc.demo.apiPayLoad.code.status.ErrorStatus;

public class StoreHandler extends GeneralException {

    public StoreHandler(ErrorStatus errorCode) {
        super(errorCode);
    }
}