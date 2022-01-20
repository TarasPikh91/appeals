package com.appeals.appeals.application;

import com.appeals.appeals.domain.User;
import com.appeals.appeals.domain.UserRole;
import com.appeals.appeals.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserAppTest {

    @Mock
    private UserRepository userRepository;
    private UserApp userApp;

    @BeforeEach
    private void beforeEach() {
        userApp = new UserApp(userRepository);
    }

    @Test
    void saveUser() {
        User user = new User("tarasua", "Pikh Taras", "12345", "taraspih@gmail.com", "0936656609", UserRole.ADMIN);
        userApp.saveUser(user.convertToDto());
        verify(userRepository).save(user);
    }

    @Test
    void deleteUserById() {
        User user = new User("tarasua", "Pikh Taras", "12345", "taraspih@gmail.com", "0936656609", UserRole.ADMIN);
        userApp.deleteUserById(user.getId());
        verify(userRepository).deleteById(user.getId());
    }

    @Test
    void findById() {
        User user = new User("tarasua", "Pikh Taras", "12345", "taraspih@gmail.com", "0936656609", UserRole.ADMIN);
        userApp.findById(user.getId());
        verify(userRepository).findById(user.getId());

    }

    @Test
    void findAll() {
        userApp.findAll();
        verify(userRepository).findAll();
    }
}