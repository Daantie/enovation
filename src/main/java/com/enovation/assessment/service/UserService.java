package com.enovation.assessment.service;

import com.enovation.assessment.domain.User;
import com.enovation.assessment.exception.UserNotFoundException;
import com.enovation.assessment.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    User getUserByEmailAddress(String emailAddress) {
        return userRepository.findByEmail(emailAddress).orElseThrow(() -> new UserNotFoundException("No user with email " + emailAddress));
    }

    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("No user with id " + id));
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
