package ru.unecon.reflection;

import ru.unecon.dates.Date;
import ru.unecon.dates.DayOfYearDate;
import ru.unecon.factory.AbstractDateFactory;
import ru.unecon.factory.DateFactory;

public class CreationWithFactory {
    public static void main(String[] args) {
        AbstractDateFactory dateFactory = new DateFactory(DayOfYearDate.class);

        Date date = dateFactory.create();
        System.out.format("Сегодня %d.%d, %d-й день года%n", date.getDay(), date.getMonth(), date.getDayOfYear());
    }
}
