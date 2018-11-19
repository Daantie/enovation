package com.enovation.assessment.web.rest.validation;

import com.enovation.assessment.domain.RegistrationForm;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        if (obj instanceof RegistrationForm) {
            RegistrationForm user = (RegistrationForm) obj;
            return user.getPassword().equals(user.getPasswordRepeated());
        }
        return false;
    }

}
