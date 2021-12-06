package com.appeals.appeals.service;

import com.appeals.appeals.domain.ConfirmationToken;
import com.appeals.appeals.repository.ConfirmationTokenRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {


    private final ConfirmationTokenRepository confirmationTokenRepository;


    public void saveConfirmationToken(final ConfirmationToken token) {
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationToken> getToken(final String token) {
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedTokenAt(final String token) {
        return confirmationTokenRepository.updateConfirmedAt(token, LocalDateTime.now());
    }

}
