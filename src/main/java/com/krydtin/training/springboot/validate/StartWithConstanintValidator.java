package com.krydtin.training.springboot.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 *
 * @author krydtin
 */
class StartWithConstanintValidator implements ConstraintValidator<StartWith, String> {

    private String startWith;

    @Override
    public void initialize(StartWith startWith) {
        this.startWith = startWith.value();
    }

    @Override
    public boolean isValid(String inputValue, ConstraintValidatorContext cvc) {

        cvc.disableDefaultConstraintViolation();
        cvc
                .buildConstraintViolationWithTemplate("String must start with " + startWith)
                .addConstraintViolation();

        return inputValue.startsWith(startWith);
    }

}
