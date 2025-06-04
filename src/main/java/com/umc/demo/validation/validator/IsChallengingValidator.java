package com.umc.demo.validation.validator;

import com.umc.demo.Exception.Handler.MissionHandler;
import com.umc.demo.Exception.Handler.RequestHandler;
import com.umc.demo.apiPayLoad.code.status.ErrorStatus;
import com.umc.demo.service.UserService.UserMissionCommandService;
import com.umc.demo.validation.annotation.IsChallenging;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class IsChallengingValidator implements ConstraintValidator<IsChallenging, Long> {
    private final UserMissionCommandService userMissionCommandService;
    private final HttpServletRequest request;

    @Override
    public void initialize(IsChallenging constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) throw new MissionHandler(ErrorStatus.MISSION_NOT_FOUND);

        String uri = request.getRequestURI();  // e.g. "/users/42/userMission/challenge"
        if(uri == null) throw new RequestHandler(ErrorStatus.URI_NOT_FOUND);
        String[] parts = uri.split("/");
        if(parts.length < 4) throw new RequestHandler(ErrorStatus.WRONG_URI_FORM);
        Long userId = Long.parseLong(parts[2]); // "42"

        boolean isValid = userMissionCommandService.isExist(value, userId);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.ALREADY_CHALLENGING_MISSION.toString()).addConstraintViolation();
        }
        return isValid;    // false면 ConstraintViolationException 발생
    }
}
