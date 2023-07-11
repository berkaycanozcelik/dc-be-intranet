package com.demirtag.intranet.service;

import com.demirtag.intranet.model.EmployeeDetail;
import com.demirtag.intranet.repository.EmployeeDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeDetailService {

    private final EmployeeDetailRepository employeeDetailRepository;

    @Autowired
    public EmployeeDetailService(EmployeeDetailRepository employeeDetailRepository) {
        this.employeeDetailRepository = employeeDetailRepository;
    }


    public EmployeeDetail createEmployeeDetail(EmployeeDetail employeeDetail) {
        return employeeDetailRepository.save(employeeDetail);
    }

    public Optional<EmployeeDetail> getEmployeeDetail(Long id) {
        return employeeDetailRepository.findById(id);
    }

    public EmployeeDetail updateEmployeeDetail(EmployeeDetail employeeDetail) {
        return employeeDetailRepository.save(employeeDetail);
    }

    public boolean deleteEmployeeDetail(Long id) {
        Optional<EmployeeDetail> employeeDetail = employeeDetailRepository.findById(id);
        if (employeeDetail.isPresent()) {
            employeeDetailRepository.delete(employeeDetail.get());
            return true;
        }
        return false;
    }
}
