package com.demirtag.intranet.service;

import com.demirtag.intranet.repository.EmployeeDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailService {

    private final EmployeeDetailRepository employeeDetailRepository;

    @Autowired
    public EmployeeDetailService(EmployeeDetailRepository employeeDetailRepository) {
        this.employeeDetailRepository = employeeDetailRepository;
    }
}
