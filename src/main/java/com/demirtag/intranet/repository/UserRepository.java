package com.demirtag.intranet.repository;

import com.demirtag.intranet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
