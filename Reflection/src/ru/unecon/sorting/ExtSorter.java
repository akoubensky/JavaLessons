package ru.unecon.sorting;

import java.lang.reflect.Field;
import java.util.Arrays;

public class ExtSorter {
    public static void main(String[] args) {
        Sorter sorter = new Sorter("QuickSort");
        Class<?> sorterClass = sorter.getClass();
        try {
            Field f = sorterClass.getDeclaredField("sortMethod");
            f.setAccessible(true);
            try {
                if (f.get(sorter) != null) {
                    f.set(sorter, SortMethods.class.getMethod("InsertSort", Comparable[].class));
                }
                String[] data1 = { "у", "попа", "была", "собака", "он", "ее","любил" };
                System.out.println(Arrays.toString(data1));
                sorter.sort(data1);
                System.out.println(Arrays.toString(data1));
            } catch (Exception e) {
                System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
        }

    }
}
