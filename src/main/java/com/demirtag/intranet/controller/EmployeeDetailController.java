package com.demirtag.intranet.controller;

import com.demirtag.intranet.model.EmployeeDetail;
import com.demirtag.intranet.service.EmployeeDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/employee-details")
public class EmployeeDetailController {

    private final EmployeeDetailService employeeDetailService;

    @Autowired
    public EmployeeDetailController(EmployeeDetailService employeeDetailService) {
        this.employeeDetailService = employeeDetailService;
    }

    @PostMapping("/create")
    public ResponseEntity<EmployeeDetail> createEmployeeDetail(@RequestBody EmployeeDetail employeeDetail) {
        EmployeeDetail savedEmployeeDetail = employeeDetailService.createEmployeeDetail(employeeDetail);
        return ResponseEntity.ok(savedEmployeeDetail);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDetail> getEmployeeDetail(@PathVariable Long id) {
        Optional<EmployeeDetail> employeeDetail = employeeDetailService.getEmployeeDetail(id);
        return employeeDetail.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDetail> updateEmployeeDetail(@PathVariable Long id, @RequestBody EmployeeDetail employeeDetail) {
        Optional<EmployeeDetail> existingEmployeeDetail = employeeDetailService.getEmployeeDetail(id);
        if (existingEmployeeDetail.isPresent()) {
            employeeDetail.setId(id);
            EmployeeDetail updatedEmployeeDetail = employeeDetailService.updateEmployeeDetail(employeeDetail);
            return ResponseEntity.ok(updatedEmployeeDetail);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployeeDetail(@PathVariable Long id) {
        if (employeeDetailService.deleteEmployeeDetail(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
