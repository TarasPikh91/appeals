package com.appeals.appeals.controller;

import com.appeals.appeals.configuration.RegistrationRequest;
import com.appeals.appeals.configuration.security.EmailValidatorImpl;
import com.appeals.appeals.domain.User;
import com.appeals.appeals.service.ConfirmationTokenService;
import com.appeals.appeals.service.RegistrationService;
import com.appeals.appeals.service.UserService;
import com.appeals.appeals.service.mail.EmailSender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class RegistrationControllerTest {

    @Mock
    private RegistrationService registrationService;
    private EmailValidatorImpl emailValidatorImpl;
    private UserService userService;
    private ConfirmationTokenService confirmationTokenService;
    private EmailSender emailSender;

    @BeforeEach
    private void beforeAll() {
        emailValidatorImpl = new EmailValidatorImpl();
        userService = Mockito.mock(UserService.class);
        confirmationTokenService = Mockito.mock(ConfirmationTokenService.class);
        emailSender = Mockito.mock(EmailSender.class);
    }

    @Test
    void registerUser() {
        RegistrationRequest registrationRequest = new RegistrationRequest("Taras Pikh", "tarasua", "taraspih@gmail.com", "12345", "0936656609");
        registrationService.register(registrationRequest);

        verify(registrationService).register(registrationRequest);
    }
}