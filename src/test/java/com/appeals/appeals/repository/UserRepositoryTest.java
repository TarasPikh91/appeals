package com.appeals.appeals.repository;

import com.appeals.appeals.domain.User;
import com.appeals.appeals.domain.UserRole;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;



@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    @Mock
    private UserRepository underTest;

    @Test
    void checkFindByEmail() {
        //given
        User user = new User("taras", "Pikh", "12345678", "taraspih@gmail.com", "0936656609", UserRole.USER_ROLE);
        underTest.save(user);

        //when
        final Optional<User> isEmailValid = underTest.findByEmail(user.getEmail());

        //then
         assertTrue(isEmailValid.isPresent());

    }

    @Test
    void checkEnableUserByEmail() {
        //given
        //when
        //then
    }

    @Test
    void canAddUser() {
        User user = new User("taras", "Pikh", "12345678", "taraspih@gmail.com", "0936656609", UserRole.USER_ROLE);
        underTest.save(user);

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
        verify(underTest).save(userArgumentCaptor.capture());
        User cupturedUser = userArgumentCaptor.getValue();
        assertThat(cupturedUser).isEqualTo(user);
    }
}