package com.appeals.appeals.configuration.security;

import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;

@Configuration
public class EmailValidatorImpl implements Predicate<String> {

    @Override
    public boolean test(String s) {
        return EmailValidator.getInstance().isValid(s);
    }
}
