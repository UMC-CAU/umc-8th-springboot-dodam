package com.umc.demo.apiPayLoad.code.status;

import com.umc.demo.apiPayLoad.code.BaseErrorCode;
import com.umc.demo.apiPayLoad.code.ErrorReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // COMMON 오류
    URI_NOT_FOUND(HttpStatus.BAD_REQUEST,"COMMON4001","URI가 입력되지 않았습니다."),
    WRONG_URI_FORM(HttpStatus.BAD_REQUEST,"COMMON4002","잘못된 URI 형식입니다."),
    BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON4003","유효성 검사 실패 "),

    // Food Category 오류
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.BAD_REQUEST,"FOOD4001","해당 ID를 가진 음식이 없습니다. "),

    // Mission 오류
    MISSION_NOT_FOUND(HttpStatus.BAD_REQUEST,"MISSION4001","해당 ID를 가진 미션이 없습니다."),
    ALREADY_CHALLENGING_MISSION(HttpStatus.BAD_REQUEST,"MISSION4002","이미 실행 중인 미션입니다. "),

    // Region 오류
    REGION_NOT_FOUND(HttpStatus.BAD_REQUEST,"REGION4001","해당 ID를 가진 지역이 없습니다."),

    // Store 오류
    STORE_NOT_FOUND(HttpStatus.BAD_REQUEST,"STORE4001","해당 ID를 가진 가게가 없습니다."),

    // User 오류
    USER_NOT_FOUND(HttpStatus.BAD_REQUEST,"USER4001","해당 ID를 가진 사용자가 없습니다.");

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