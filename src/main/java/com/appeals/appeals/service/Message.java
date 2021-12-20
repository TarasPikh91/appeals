package com.appeals.appeals.service;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

@Service
public class Message {


    private final MessageSource messageSource;

    public Message(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public String getMessage(final String messageCode) {
        return messageSource.getMessage(messageCode, null, LocaleContextHolder.getLocale());
    }

    public String getMessage(final String messageCode, final Object[] args) {
        return messageSource.getMessage(messageCode, args, LocaleContextHolder.getLocale());
    }

}
