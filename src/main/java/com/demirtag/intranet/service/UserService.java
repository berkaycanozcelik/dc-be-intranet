package com.demirtag.intranet.service;

import com.demirtag.intranet.model.RegisterRequest;
import com.demirtag.intranet.model.User;
import com.demirtag.intranet.model.UserDetail;
import com.demirtag.intranet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, RegisterRequest updatedUser) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setFirstName(updatedUser.getFirstName());
                    user.setLastName(updatedUser.getLastName());
                    user.setEmail(updatedUser.getEmail());
                    if(updatedUser.getPassword() != null){
                        user.setPassword(passwordEncoder.encode(updatedUser.getPassword()));

                    }
                    user.setRole(updatedUser.getRole());

                    UserDetail userDetail =user.getUserDetail();

                    userDetail.setAddress(updatedUser.getAddress());
                    userDetail.setPhoneNumber(updatedUser.getPhoneNumber());
                    userDetail.setBirthday(updatedUser.getBirthday());
                    userDetail.setTitle(updatedUser.getTitle());
                    userDetail.setManager(updatedUser.getManager());
                    userDetail.setTeam(updatedUser.getTeam());

                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
