package com.umc.demo.validation.validator;

import com.umc.demo.Exception.Handler.PageHandler;
import com.umc.demo.apiPayLoad.code.status.ErrorStatus;
import com.umc.demo.validation.annotation.CheckPage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PageCheckValidator implements ConstraintValidator<CheckPage, Integer> {
    @Override
    public void initialize(CheckPage constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        if (value == null || value <= 0){
            throw new PageHandler(ErrorStatus.PAGE_FAULT);
        }else {
            return true;
        }
    }
}
