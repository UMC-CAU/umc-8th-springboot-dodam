package com.umc.demo.validation.validator;

import com.umc.demo.apiPayLoad.code.status.ErrorStatus;
import com.umc.demo.service.StoreService.StoreCommandService;
import com.umc.demo.service.UserService.UserQueryService;
import com.umc.demo.validation.annotation.ExistStores;
import com.umc.demo.validation.annotation.ExistUsers;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsersExistValidator implements ConstraintValidator<ExistUsers, Long>{
    private final UserQueryService userQueryService;

    @Override
    public void initialize(ExistUsers constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = userQueryService.isExist(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.USER_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;    // false면 ConstraintViolationException 발생

    }
}
