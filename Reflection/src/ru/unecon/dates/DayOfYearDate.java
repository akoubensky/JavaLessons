package ru.unecon.dates;

import java.time.LocalDate;

public class DayOfYearDate implements Date {
    private int dayOfYear;

    public DayOfYearDate() {
        dayOfYear = LocalDate.now().getDayOfYear();
    }

    public DayOfYearDate(int dayOfYear) {
        this.dayOfYear = dayOfYear;
    }

    @Override
    public int getDayOfYear() {
        return dayOfYear;
    }
}
