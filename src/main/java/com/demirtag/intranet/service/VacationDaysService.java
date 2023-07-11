package com.demirtag.intranet.service;

import com.demirtag.intranet.repository.VacationDaysRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class VacationDaysService {

    private final VacationDaysRepository vacationDaysRepository;

    @Autowired
    public VacationDaysService(VacationDaysRepository vacationDaysRepository) {
        this.vacationDaysRepository = vacationDaysRepository;
    }
}
