package com.demirtag.intranet.controller;

import com.demirtag.intranet.model.VacationDays;
import com.demirtag.intranet.service.VacationDaysService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/vacation-days")
public class VacationDaysController {
    private final VacationDaysService vacationDaysService;

    public VacationDaysController(VacationDaysService vacationDaysService) {
        this.vacationDaysService = vacationDaysService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacationDays> getVacationDaysById(@PathVariable Long id) {
        VacationDays vacationDays = vacationDaysService.getVacationDaysById(id);
        if (vacationDays != null) {
            return ResponseEntity.ok(vacationDays);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/create")
    public ResponseEntity<VacationDays> createVacationDays(@RequestBody VacationDays vacationDays) {
        VacationDays savedVacationDays = vacationDaysService.createVacationDays(vacationDays);
        return ResponseEntity.ok(savedVacationDays);
    }

}
