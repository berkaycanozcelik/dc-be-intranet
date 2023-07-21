package com.demirtag.intranet.controller;

import com.demirtag.intranet.model.Holiday;
import com.demirtag.intranet.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @GetMapping
    public List<Holiday> getAllHolidays() {
        return holidayService.getAllHolidays();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Holiday> getHoliday(@PathVariable Long id) {
        Optional<Holiday> holiday = holidayService.getHoliday(id);
        return holiday.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Holiday> createHoliday(@RequestBody Holiday holiday) {
        Holiday createdHoliday = holidayService.createHoliday(holiday);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdHoliday);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Holiday> updateHoliday(@PathVariable Long id, @RequestBody Holiday holiday) {
        holiday.setId(id);
        Holiday updatedHoliday = holidayService.updateHoliday(holiday);
        return ResponseEntity.ok(updatedHoliday);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteHoliday(@PathVariable Long id){
        Boolean deletedHoliday = holidayService.deleteHoliday(id);
        return ResponseEntity.ok(deletedHoliday);
    }
}
