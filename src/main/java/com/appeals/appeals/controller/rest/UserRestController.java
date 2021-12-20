package com.appeals.appeals.controller.rest;

import com.appeals.appeals.application.UserApp;
import com.appeals.appeals.domain.User;
import com.appeals.appeals.service.Message;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class UserRestController {

    private final UserApp userApp;
    private final Message message;

    public UserRestController(UserApp userApp, Message message) {
        this.userApp = userApp;
        this.message = message;
    }

    @GetMapping("/users")
    List<User> getAll() {
        return userApp.findAll();
    }

    @PostMapping("/save")
    void saveUser(@RequestBody final User user) {
        userApp.saveUser(user.convertToDto());
    }

    @PostMapping("/delete")
    void deleteUser(@RequestParam final Long id) {
        userApp.deleteUserById(id);
    }

    @GetMapping("/get_by_id")
    User getUserById(@RequestParam final Long id) {
        final Optional<User> userOpt = userApp.findById(id);
        if (userOpt.isEmpty()) {
            throw new UsernameNotFoundException(message.getMessage("message.user_not_found.label"));
        }
        return userOpt.get();
    }
}
