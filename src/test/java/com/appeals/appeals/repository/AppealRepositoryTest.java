package com.appeals.appeals.repository;

import com.appeals.appeals.application.AppealApp;
import com.appeals.appeals.domain.Appeal;
import com.appeals.appeals.domain.User;
import com.appeals.appeals.domain.UserRole;
import com.appeals.appeals.dto.AppealDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AppealRepositoryTest {

    @Mock
    private AppealRepository appealRepository;
    private AppealApp underTest;

    @BeforeEach
    void setUp() {
        underTest = new AppealApp(appealRepository);
    }

    @Test
    void getAllAppeals() {
        //when
        underTest.getAppeals();
        //then
        verify(appealRepository).findAll();


    }

    @Test
    @Disabled
    void getAppealById() {
//        AppealApp appealApp = mock(AppealApp.class);        // creat mock object

        User user = new User("taras", "Pikh", "12345678", "taraspih@gmail.com", "0936656609", UserRole.USER_ROLE);
        Appeal appeal = new Appeal((long)123124235, new Date(), "test appeal", user);
    }

    @Test
    @Disabled
    void deleteAppealById() {
    }
}