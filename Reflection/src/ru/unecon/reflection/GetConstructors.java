package ru.unecon.reflection;

import ru.unecon.complex.Complex;
import ru.unecon.dates.Date;
import ru.unecon.dates.DayMonthDate;
import ru.unecon.dates.DayOfYearDate;
import ru.unecon.factory.AbstractDateFactory;
import ru.unecon.factory.DateFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class GetConstructors {
    private static final AbstractDateFactory abstractDateFactory = new DateFactory(DayMonthDate.class);

    private static void creatingWithConstructors()
            throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Date date = abstractDateFactory.create();
        Class<? extends Date> dateClass = date.getClass();
        Constructor<? extends Date>[] publicConstructors = (Constructor<? extends Date>[]) dateClass.getConstructors();

        List<Date> dates = new ArrayList<>();
        for (Constructor<? extends Date> constr : publicConstructors) {
            Class<?>[] parameterClasses = constr.getParameterTypes();
            dates.add(parameterClasses.length == 0 ? constr.newInstance() :
                    parameterClasses.length == 1 ? constr.newInstance(256) :
                            constr.newInstance(31, 12));
        }
        System.out.println(dates);
    }

    private static void methodNames() {
        Class<DayMonthDate> clazz = DayMonthDate.class;
        System.out.println("Method names:");
        System.out.println("-------------");
        Stream.of(clazz.getMethods()).map(Method::getName).sorted().forEach(System.out::println);
        System.out.println();
        System.out.println("Declared method names:");
        System.out.println("----------------------");
        Stream.of(clazz.getDeclaredMethods()).map(Method::getName).sorted().forEach(System.out::println);
    }

    private static void methodsInvokation() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Date[] dates = { new DayMonthDate(12, 4), new DayOfYearDate(256) };
        System.out.println();
        for (Date dt : dates) {
            Class<? extends Date> clazz = dt.getClass();
            Method getDayOfYear = clazz.getMethod("getDayOfYear");
            System.out.println(getDayOfYear.invoke(dt));
        }
        Method plusMethod = Complex.class.getMethod("plus", Complex.class);
        Method staticPlusMethod = Complex.class.getMethod("plus", Complex.class, Complex.class);
        Complex c1 = new Complex(1, 2);
        Complex c2 = new Complex(2, 3);
        System.out.println(plusMethod.invoke(c1, c2));
        System.out.println(staticPlusMethod.invoke(null, c1, c2));
    }

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {
        methodNames();
        creatingWithConstructors();
        methodsInvokation();
    }
}
