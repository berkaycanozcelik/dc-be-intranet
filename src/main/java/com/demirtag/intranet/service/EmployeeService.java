package com.demirtag.intranet.service;

import com.demirtag.intranet.model.Employee;
import com.demirtag.intranet.model.Holiday;
import com.demirtag.intranet.repository.EmployeeRepository;
import com.demirtag.intranet.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }
}
