package com.appeals.appeals.application;

import com.appeals.appeals.domain.User;
import com.appeals.appeals.dto.UserDto;
import com.appeals.appeals.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserApp {

    private final UserRepository userRepository;

    public UserApp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(final UserDto userDto) {
        userRepository.save(new User(userDto));
    }

    public void deleteUserById(final Long id) {
        userRepository.deleteById(id);
    }

    public Optional<User> findById(final Long id) {
        return userRepository.findById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

}
