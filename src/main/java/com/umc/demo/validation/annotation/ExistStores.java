package com.umc.demo.validation.annotation;

import com.umc.demo.validation.validator.StoresExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented    // 사용자 정의 어노테이션 만들 때 사용
@Constraint(validatedBy = StoresExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })   // 어노테이션 적용 범위 지정
@Retention(RetentionPolicy.RUNTIME)   // 어노테이션 생명 주기
public @interface ExistStores {
    String message() default "해당하는 가게가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
