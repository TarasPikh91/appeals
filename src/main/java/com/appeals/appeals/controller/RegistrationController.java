package com.appeals.appeals.controller;

import com.appeals.appeals.configuration.RegistrationRequest;
import com.appeals.appeals.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/signUp")
    public String signUp() {
        return "/signUp";
    }

    @PostMapping(value = "/signUp")
    public String registerUser(RegistrationRequest registrationRequest) {
        Optional<String> token = Optional.of(registrationService.register(registrationRequest));
        if (token.isPresent()) {
            registrationService.confirmToken(token.get());
        }
        return  "redirect:/login";
    }
}
