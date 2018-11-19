package com.enovation.assessment.web.rest;

import com.enovation.assessment.domain.RegistrationForm;
import com.enovation.assessment.domain.User;
import com.enovation.assessment.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/list", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<User> getAllUsers() {
        log.info("Getting all users...");
        return userService.getAllUsers();
    }

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getUserById(@RequestParam("id") long userId) {
        log.info("Getting single user...");
        return userService.getUserById(userId);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Void> registerNewUser(@RequestBody @Valid RegistrationForm registrationForm) {
        log.info("Registering user...");
        User user = new User(registrationForm.getEmail(), registrationForm.getPassword(), registrationForm.getFirstName(), registrationForm.getLastName());
        try {
            userService.saveUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
