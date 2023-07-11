package com.demirtag.intranet.service;

import com.demirtag.intranet.model.UserDetail;
import com.demirtag.intranet.repository.UserDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailService {

    private final UserDetailRepository userDetailRepository;

    @Autowired
    public UserDetailService(UserDetailRepository userDetailRepository) {
        this.userDetailRepository = userDetailRepository;
    }


    public UserDetail createUserDetail(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }

    public Optional<UserDetail> getUserDetail(Long id) {
        return userDetailRepository.findById(id);
    }

    public UserDetail updateUserDetail(UserDetail userDetail) {
        return userDetailRepository.save(userDetail);
    }

    public boolean deleteUserDetail(Long id) {
        Optional<UserDetail> userDetail = userDetailRepository.findById(id);
        if (userDetail.isPresent()) {
            userDetailRepository.delete(userDetail.get());
            return true;
        }
        return false;
    }
}
