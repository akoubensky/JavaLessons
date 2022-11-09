package ru.unecon.factory;

import ru.unecon.dates.Date;

import java.lang.reflect.InvocationTargetException;

public class DateFactory implements AbstractDateFactory {
    private final Class<? extends Date> clazz;

    public DateFactory(Class<? extends Date> clazz) {
        this.clazz = clazz;
    }

    @Override
    public Date create() {
        try {
            return clazz.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            return null;
        }
    }
}
