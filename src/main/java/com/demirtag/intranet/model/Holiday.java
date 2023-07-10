package com.demirtag.intranet.model;

import jakarta.persistence.*;

@Entity
@Table(name = "holiday")
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String startDate;
    private String endDate;
    private int remainingDays;
    private int vacationWorkdays;
    private String reason;
    private boolean confirmation1;
    private boolean confirmation2;
    private String replacement;
    private String status;

    public Holiday() {
    }

    public Holiday(String startDate, String endDate, int remainingDays, int vacationWorkdays, String reason, boolean confirmation1, boolean confirmation2, String replacement, String status) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.remainingDays = remainingDays;
        this.vacationWorkdays = vacationWorkdays;
        this.reason = reason;
        this.confirmation1 = confirmation1;
        this.confirmation2 = confirmation2;
        this.replacement = replacement;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getRemainingDays() {
        return remainingDays;
    }

    public void setRemainingDays(int remainingDays) {
        this.remainingDays = remainingDays;
    }

    public int getVacationWorkdays() {
        return vacationWorkdays;
    }

    public void setVacationWorkdays(int vacationWorkdays) {
        this.vacationWorkdays = vacationWorkdays;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public boolean isConfirmation1() {
        return confirmation1;
    }

    public void setConfirmation1(boolean confirmation1) {
        this.confirmation1 = confirmation1;
    }

    public boolean isConfirmation2() {
        return confirmation2;
    }

    public void setConfirmation2(boolean confirmation2) {
        this.confirmation2 = confirmation2;
    }

    public String getReplacement() {
        return replacement;
    }

    public void setReplacement(String replacement) {
        this.replacement = replacement;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Holiday{" +
                "id=" + id +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", remainingDays=" + remainingDays +
                ", vacationWorkdays=" + vacationWorkdays +
                ", reason='" + reason + '\'' +
                ", confirmation1=" + confirmation1 +
                ", confirmation2=" + confirmation2 +
                ", replacement='" + replacement + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
