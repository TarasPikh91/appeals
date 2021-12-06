package com.appeals.appeals.service;

import com.appeals.appeals.configuration.security.PasswordEncoder;
import com.appeals.appeals.domain.ConfirmationToken;
import com.appeals.appeals.domain.User;
import com.appeals.appeals.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

//    @Value("load.user.by.email.not.found")
    private final String USER_NOT_FOUND_EMAIL = "User with this email %s doesn't exists";

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final ConfirmationTokenService confirmationTokenService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format(USER_NOT_FOUND_EMAIL, email)));
    }

    public String signUpUser(User user) {
        final boolean userExist = userRepository.findByEmail(user.getEmail()).isPresent();
        if (userExist) {
            throw new IllegalStateException("User exixsts");
        }

        final String encodedPassword = passwordEncoder.bCryptPasswordEncoder().encode(user.getPassword());
        user.setPassword(encodedPassword);

        userRepository.save(user);

        String token = UUID.randomUUID().toString();
        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                user
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);


        //TODO: send email
        return token;
    }

    public void enableUser(final String email) {
        userRepository.enableUserByEmail(email);
    }
}
