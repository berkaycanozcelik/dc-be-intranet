package com.demirtag.intranet.controller;

import com.demirtag.intranet.model.Holiday;
import com.demirtag.intranet.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/holidays")
public class HolidayController {

    private final HolidayService holidayService;

    @Autowired
    public HolidayController( HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @PostMapping("/create")
    public ResponseEntity<Holiday> createHoliday(@RequestBody Holiday holiday) {
        Holiday savedHoliday = holidayService.createHoliday(holiday);
        return ResponseEntity.ok(savedHoliday);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Holiday> getHoliday(@PathVariable Long id) {
        Optional<Holiday> holiday = holidayService.getHoliday(id);
        return holiday.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Holiday> updateHoliday(@PathVariable Long id, @RequestBody Holiday holiday) {
        Optional<Holiday> existingHoliday = holidayService.getHoliday(id);
        if (existingHoliday.isPresent()) {
            holiday.setId(id);
            Holiday updatedHoliday = holidayService.updateHoliday(holiday);
            return ResponseEntity.ok(updatedHoliday);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHoliday(@PathVariable Long id) {
        if (holidayService.deleteHoliday(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
