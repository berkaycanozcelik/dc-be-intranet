package com.demirtag.intranet.repository;

import com.demirtag.intranet.model.Employee;
import com.demirtag.intranet.model.Holiday;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
