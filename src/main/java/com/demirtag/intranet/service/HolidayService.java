package com.demirtag.intranet.service;

import com.demirtag.intranet.model.Holiday;
import com.demirtag.intranet.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HolidayService {

    private final HolidayRepository holidayRepository;

    @Autowired
    public HolidayService(HolidayRepository holidayRepository) {
        this.holidayRepository = holidayRepository;
    }

    public Holiday saveHoliday(Holiday holiday){
        return holidayRepository.save(holiday);
    }

    public Holiday createHoliday(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    public List<Holiday> getAllHolidays() {
        return holidayRepository.findAll();
    }

    public Optional<Holiday> getHoliday(Long id) {
        return holidayRepository.findById(id);
    }

    public Holiday updateHoliday(Holiday holiday) {
        return holidayRepository.save(holiday);
    }

    public boolean deleteHoliday(Long id) {
        Optional<Holiday> holiday = holidayRepository.findById(id);
        if (holiday.isPresent()) {
            holidayRepository.delete(holiday.get());
            return true;
        }
        return false;
    }
}
