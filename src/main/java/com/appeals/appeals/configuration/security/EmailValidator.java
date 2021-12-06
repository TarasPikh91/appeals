package com.appeals.appeals.configuration.security;

import org.springframework.context.annotation.Configuration;

import java.util.function.Predicate;

@Configuration
public class EmailValidator implements Predicate<String> {

    @Override
    public boolean test(String s) {
        //TODO make validate
        return true;
    }
}
