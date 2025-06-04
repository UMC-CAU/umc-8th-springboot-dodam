package com.umc.demo.Exception.Handler;

import com.umc.demo.Exception.GeneralException;
import com.umc.demo.apiPayLoad.code.status.ErrorStatus;

public class FoodCategoryHandler extends GeneralException {

    public FoodCategoryHandler(ErrorStatus errorCode) {
        super(errorCode);
    }
}