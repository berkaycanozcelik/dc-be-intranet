package com.demirtag.intranet.repository;

import com.demirtag.intranet.model.EmployeeDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailRepository extends JpaRepository<EmployeeDetail,Long> {
}
