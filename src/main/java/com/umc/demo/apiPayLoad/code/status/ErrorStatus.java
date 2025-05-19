package com.umc.demo.apiPayLoad.code.status;

import com.umc.demo.apiPayLoad.code.BaseErrorCode;
import com.umc.demo.apiPayLoad.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    FOOD_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST,"COMMON4001","해당 ID를 가진 음식이 없습니다. "),

    MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST,"COMMON4002","해당 ID를 가진 미션이 없습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getErrorReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}