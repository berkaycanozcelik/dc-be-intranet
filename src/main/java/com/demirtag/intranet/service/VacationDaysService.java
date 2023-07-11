package com.demirtag.intranet.service;

import com.demirtag.intranet.model.VacationDays;
import com.demirtag.intranet.repository.VacationDaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VacationDaysService {
    private final VacationDaysRepository vacationDaysRepository;

    public VacationDaysService(VacationDaysRepository vacationDaysRepository) {
        this.vacationDaysRepository = vacationDaysRepository;
    }

    public VacationDays getVacationDaysById(Long id) {
        return vacationDaysRepository.findById(id).orElse(null);
    }

    public VacationDays createVacationDays(VacationDays vacationDays) {
        return vacationDaysRepository.save(vacationDays);
    }
}

