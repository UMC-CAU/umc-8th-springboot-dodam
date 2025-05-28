package com.umc.demo.validation.validator;

import com.umc.demo.apiPayLoad.code.status.ErrorStatus;
import com.umc.demo.service.MissionService.MissionQueryService;
import com.umc.demo.validation.annotation.ExistUserMissions;
import com.umc.demo.validation.annotation.ExistUsers;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMissionExistValidator implements ConstraintValidator<ExistUserMissions, Long> {

    private final MissionQueryService missionQueryService;

    @Override
    public void initialize(ExistUserMissions constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = missionQueryService.isExist(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MISSION_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;    // false면 ConstraintViolationException 발생

    }
}
