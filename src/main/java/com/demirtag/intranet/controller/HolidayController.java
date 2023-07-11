package com.demirtag.intranet.controller;

import com.demirtag.intranet.model.Holiday;
import com.demirtag.intranet.repository.HolidayRepository;
import com.demirtag.intranet.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(maxAge = 3600)
@RestController
@RequestMapping("/api/holidays")
public class HolidayController {

    private final HolidayRepository holidayRepository;
    private final HolidayService holidayService;

    @Autowired
    public HolidayController(HolidayRepository holidayRepository, HolidayService holidayService) {
        this.holidayRepository = holidayRepository;
        this.holidayService = holidayService;
    }

    @GetMapping
    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    @GetMapping("/{id}")
    public Holiday getHolidayById(@PathVariable Long id) {
        return holidayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Holiday not found with id: " + id));
    }

    @PostMapping
    public ResponseEntity<Holiday> createHoliday(@RequestBody Holiday holiday) {
        Holiday savedHoliday = holidayService.saveHoliday(holiday);
        return ResponseEntity.ok(savedHoliday);
    }

    @PutMapping("/{id}")
    public Holiday updateHoliday(@PathVariable Long id, @RequestBody Holiday updatedHoliday) {
        return holidayRepository.findById(id)
                .map(holiday -> {
                    holiday.setStartDate(updatedHoliday.getStartDate());
                    holiday.setEndDate(updatedHoliday.getEndDate());
                    holiday.setVacationWorkdays(updatedHoliday.getVacationWorkdays());
                    holiday.setReason(updatedHoliday.getReason());
                    holiday.setConfirmation1(updatedHoliday.isConfirmation1());
                    holiday.setConfirmation2(updatedHoliday.isConfirmation2());
                    holiday.setReplacement(updatedHoliday.getReplacement());
                    holiday.setStatus(updatedHoliday.getStatus());
                    return holidayRepository.save(holiday);
                })
                .orElseThrow(() -> new RuntimeException("Holiday not found with id: " + id));
    }


    @DeleteMapping("/{id}")
    public void deleteHoliday(@PathVariable Long id) {
        holidayRepository.deleteById(id);
    }
}
