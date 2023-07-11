package com.demirtag.intranet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vacation_days")
public class VacationDays {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long totalVacation;

    @OneToOne(mappedBy = "vacationDays"
            , cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    private Employee employee;

    public VacationDays() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTotalVacation() {
        return totalVacation;
    }

    public void setTotalVacation(Long totalVacation) {
        this.totalVacation = totalVacation;
    }

    @Override
    public String toString() {
        return "VacationDays{" +
                "id=" + id +
                ", totalVacation=" + totalVacation +
                '}';
    }
}
