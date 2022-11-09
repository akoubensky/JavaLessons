package ru.unecon.reflection;

import ru.unecon.complex.Complex;
import ru.unecon.dates.Date;
import ru.unecon.dates.DayMonthDate;
import ru.unecon.dates.DayOfYearDate;

import java.lang.reflect.InvocationTargetException;

public class ObjectCreation {
    private static void deprecatedNewInstance() {
        Class<String> stringClass = String.class;
        Class<? extends Complex> complexClass = Complex.ZERO.getClass();
        Class<? extends Date> dateClass1 = DayMonthDate.class;
        Class<? extends Date> dateClass2 = DayOfYearDate.class;
        try {
            String newS = stringClass.newInstance();
            System.out.println("Created string: [" + newS + "]");

            Complex newC = complexClass.newInstance();
            System.out.println("Created Complex: " + newC);

            Date dt1 = dateClass1.newInstance();
            System.out.format("Сегодня %d.%d, %d-й день года%n", dt1.getDay(), dt1.getMonth(), dt1.getDayOfYear());
            Date dt2 = dateClass2.newInstance();
            System.out.format("Сегодня %d.%d, %d-й день года%n", dt2.getDay(), dt2.getMonth(), dt2.getDayOfYear());
        } catch (InstantiationException e) {  // Нет конструктора "по умолчанию"
            e.printStackTrace();
        } catch (IllegalAccessException e) {  // Класс или конструктор недоступны
            e.printStackTrace();
        }
    }

    private static void legalNewInstance() throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<String> stringClass = String.class;
        Class<? extends Complex> complexClass = Complex.ZERO.getClass();
        Class<? extends Date> dateClass1 = DayMonthDate.class;
        Class<? extends Date> dateClass2 = DayOfYearDate.class;

        String newS = stringClass.getConstructor().newInstance();
        System.out.println("Created string: [" + newS + "]");

        Complex newC = complexClass.getConstructor().newInstance();
        System.out.println("Created Complex: " + newC);
        Complex newC1 = complexClass.getConstructor(Double.TYPE, Double.TYPE)
                .newInstance(0, 1);
        System.out.println("Created Complex: " + newC1);

        Date dt1 = dateClass1.getConstructor().newInstance();
        System.out.format("Сегодня %d.%d, %d-й день года%n", dt1.getDay(), dt1.getMonth(), dt1.getDayOfYear());
        Date dt2 = dateClass2.getConstructor().newInstance();
        System.out.format("Сегодня %d.%d, %d-й день года%n", dt2.getDay(), dt2.getMonth(), dt2.getDayOfYear());
        Date dt3 = dateClass2.getConstructor(Integer.TYPE)
                .newInstance(256);
        System.out.format("%d-й день года - %d.%d%n", dt3.getDayOfYear(), dt3.getDay(), dt3.getMonth());

    }

    public static void main(String[] args) throws InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        deprecatedNewInstance();
        System.out.println();
        legalNewInstance();
    }
}
