package com.demirtag.intranet.controller;

import com.demirtag.intranet.model.Holiday;
import com.demirtag.intranet.model.RegisterRequest;
import com.demirtag.intranet.model.User;
import com.demirtag.intranet.service.HolidayService;
import com.demirtag.intranet.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/users")
public class UserController {

    private  final UserService userService;
    private final HolidayService holidayService;

    @Autowired
    public UserController(UserService userService, HolidayService holidayService) {
        this.userService = userService;
        this.holidayService = holidayService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/holidays")
    public List<Holiday> GetUserHolidaysById(@RequestParam Long id){

        User user = userService.getUserById(id);

        return user.getHolidays();
    }

    @Transactional
    @PostMapping("/holiday")
    public ResponseEntity<Holiday> createHolidayForUserById(@RequestBody Holiday holiday, @RequestParam Long userId) {
        Holiday createdHoliday = holidayService.createHolidayForUserById(holiday, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHoliday);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ResponseEntity.ok(savedUser);
    }

    @Transactional
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody RegisterRequest updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
