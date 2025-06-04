package com.umc.demo.validation.annotation;

import com.umc.demo.validation.validator.CategoriesExistValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented    // 사용자 정의 어노테이션 만들 때 사용
@Constraint(validatedBy = CategoriesExistValidator.class)   // CategoriesExistValidator 클래스에 의해 유효성 검사됨
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })   // 어노테이션 적용 범위 지정 (메서드, 필드, 파라미터)
@Retention(RetentionPolicy.RUNTIME)   // 어노테이션 생명 주기
public @interface ExistCategories {

    String message() default "해당하는 카테고리가 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}