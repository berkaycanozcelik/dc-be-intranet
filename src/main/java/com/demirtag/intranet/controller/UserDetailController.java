package com.demirtag.intranet.controller;

import com.demirtag.intranet.model.UserDetail;
import com.demirtag.intranet.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/user-details")
public class UserDetailController {

    private final UserDetailService userDetailService;

    @Autowired
    public UserDetailController(UserDetailService userDetailService) {
        this.userDetailService = userDetailService;
    }

    @PostMapping("/create")
    public ResponseEntity<UserDetail> createUserDetail(@RequestBody UserDetail userDetail) {
        UserDetail savedUserDetail = userDetailService.createUserDetail(userDetail);
        return ResponseEntity.ok(savedUserDetail);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDetail> getUserDetail(@PathVariable Long id) {
        Optional<UserDetail> userDetail = userDetailService.getUserDetail(id);
        return userDetail.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDetail> updateUserDetail(@PathVariable Long id, @RequestBody UserDetail userDetail) {
        Optional<UserDetail> existingUserDetail = userDetailService.getUserDetail(id);
        if (existingUserDetail.isPresent()) {
            userDetail.setId(id);
            UserDetail updatedUserDetail = userDetailService.updateUserDetail(userDetail);
            return ResponseEntity.ok(updatedUserDetail);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserDetail(@PathVariable Long id) {
        if (userDetailService.deleteUserDetail(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
