package com.demirtag.intranet.service;

import com.demirtag.intranet.model.Holiday;
import com.demirtag.intranet.repository.HolidayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
