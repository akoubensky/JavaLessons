package ru.unecon.dates;

public interface Date {
    int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    default int getMonth() {
        int dayNumber = getDayOfYear();
        for (int i = 0; i < days.length; i++) {
            if (dayNumber <= days[i]) return i+1;
            dayNumber -= days[i];
        }
        return 0;   // error!
    }

    default int getDay() {
        int dayNumber = getDayOfYear();
        for (int i = 0; i < days.length; i++) {
            if (dayNumber <= days[i]) return dayNumber;
            dayNumber -= days[i];
        }
        return 0;   // error!
    }

    default int getDayOfYear() {
        int month = getMonth() - 1;
        int dayNumber = 0;
        for (int i = 0; i < month; i++) dayNumber += days[i];
        return dayNumber + getDay();
    }
}
