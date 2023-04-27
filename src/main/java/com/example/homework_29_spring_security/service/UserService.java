package com.example.homework_29_spring_security.service;

import com.example.homework_29_spring_security.dto.UserDto;
import com.example.homework_29_spring_security.entity.User;
import com.example.homework_29_spring_security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User saveNewUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(User user) {
        userRepository.delete(user);
    }
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
