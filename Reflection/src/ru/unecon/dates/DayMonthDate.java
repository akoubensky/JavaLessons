package ru.unecon.dates;

import java.time.LocalDate;

public class DayMonthDate implements Date {
    private int day;
    private int month;

    public DayMonthDate() {
        LocalDate now = LocalDate.now();
        day = now.getDayOfMonth();
        month = now.getMonthValue();
    }

    public DayMonthDate(int day, int month) {
        if (month < 1 || month > 12) throw new IllegalArgumentException("Invalid month");
        if (day < 1 || day > days[month-1]) throw new IllegalArgumentException("Invalid day");
        this.day = day;
        this.month = month;
    }

    @Override
    public int getDay() { return day; }

    @Override
    public int getMonth() { return month; }

    @Override
    public String toString() {
        return "DayMonthDate{" +
                "day=" + day +
                ", month=" + month +
                '}';
    }
}
