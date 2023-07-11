package com.demirtag.intranet.repository;

import com.demirtag.intranet.model.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailRepository extends JpaRepository<UserDetail,Long> {
}
